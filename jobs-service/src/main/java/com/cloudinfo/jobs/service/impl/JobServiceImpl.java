package com.cloudinfo.jobs.service.impl;

import com.cloudinfo.jobs.client.CompanyClient;
import com.cloudinfo.jobs.client.ReviewClient;
import com.cloudinfo.jobs.dto.*;
import com.cloudinfo.jobs.entity.Job;
import com.cloudinfo.jobs.exception.ResourceNotFoundException;
import com.cloudinfo.jobs.repository.JobRepository;
import com.cloudinfo.jobs.service.JobService;
import com.cloudinfo.jobs.utils.JobMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final RestTemplate restTemplate;
    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    @Override
    @Transactional
    public void createJob(JobDto jobDto) {
        //check null throw exception
        //CompanyDto companyDto=restTemplate.getForObject("http://company-service/api/v1/companies/"+jobDto.getCompanyId(), CompanyDto.class);
        if(jobDto.getCompanyId()==null){
            throw new ResourceNotFoundException("Company","id", jobDto.getCompanyId());
        }
        CompanyDto companyDto= companyClient.getCompany(jobDto.getCompanyId());


        Job job=JobMapper.mapToEntity(jobDto);
        jobRepository.save(job);
    }

    @Override
    public JobCompanyReviewDto getJobById(Long id) {
        Job job=jobRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job", "id", id));
        JobDto response=JobMapper.mapToDto(job);
        //CompanyDto companyDto=restTemplate.getForObject("http://company-service/api/v1/companies/"+job.getCompanyId(), CompanyDto.class);
        CompanyDto companyDto= companyClient.getCompany(job.getCompanyId());
//        ResponseEntity<List<ReviewDto>> reviewResponse =restTemplate.exchange("http://review-service:8083/api/v1/reviews?companyId=" + job.getCompanyId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<ReviewDto>>() {
//                });
        List<ReviewDto> reviewDtosResponse= reviewClient.getReviews(job.getCompanyId());
        return JobCompanyReviewDto.builder()
                .companyDto(companyDto)
                .jobDto(response)
                .reviewDtos(reviewDtosResponse)
                //.reviewDtos(reviewResponse.getBody())
                .build();

    }

    @Override
    @CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyBreakerFallBack")
    public List<JobWithCompanyDto> getAllJobs() {
        List<JobWithCompanyDto> response= new ArrayList<>();
        List<Job> jobs= jobRepository.findAll();
        for(Job j: jobs){
            CompanyDto companyDto= companyClient.getCompany(j.getCompanyId());
            JobWithCompanyDto jobWithCompanyDto= JobWithCompanyDto.builder()
                    .companyDto(companyDto)
                    .jobDto(JobMapper.mapToDto(j))
                    .build();
            response.add(jobWithCompanyDto);
        }
        return response;
    }
    public List<String> companyBreakerFallBack(Exception e){
        List<String> list= new ArrayList<>();
        list.add("Dummy");
        return list;
    }
}
