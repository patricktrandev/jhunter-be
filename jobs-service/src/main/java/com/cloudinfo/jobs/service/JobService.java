package com.cloudinfo.jobs.service;

import com.cloudinfo.jobs.dto.JobCompanyReviewDto;
import com.cloudinfo.jobs.dto.JobDto;
import com.cloudinfo.jobs.dto.JobWithCompanyDto;

import java.util.List;

public interface JobService {
    void createJob(JobDto jobDto);
    JobCompanyReviewDto getJobById(Long id);
    List<JobWithCompanyDto> getAllJobs();
}
