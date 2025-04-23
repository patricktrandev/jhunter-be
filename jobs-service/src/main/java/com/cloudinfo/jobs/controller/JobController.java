package com.cloudinfo.jobs.controller;

import com.cloudinfo.jobs.dto.JobCompanyReviewDto;
import com.cloudinfo.jobs.dto.JobDto;
import com.cloudinfo.jobs.dto.JobWithCompanyDto;
import com.cloudinfo.jobs.dto.ResponseDto;
import com.cloudinfo.jobs.service.JobService;
import com.cloudinfo.jobs.utils.JobConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobs")
@RequiredArgsConstructor
@Tag(name = "CRUD REST API for Job Resource")
public class JobController {
    private final JobService jobService;
    private static Logger logger= LoggerFactory.getLogger(JobController.class);

    @Operation(summary = "Create new job posting")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Job posting created successfully"),
            @ApiResponse(responseCode = "500", description = "Http status Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<ResponseDto> createJob(@RequestBody JobDto jobDto){
            jobService.createJob(jobDto);
            logger.info("Job created successfully.");
        return new ResponseEntity<>(ResponseDto.builder()
                .message(JobConstant.MESSAGE_201)
                .status(JobConstant.STATUS_201)
                .build(), HttpStatus.CREATED);
    }
    @Operation(summary = "Invoke job by id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getJobById(@PathVariable Long id){
        JobCompanyReviewDto jobDto=jobService.getJobById(id);
        return new ResponseEntity<>(ResponseDto.builder()
                .status(JobConstant.STATUS_200)
                .message(JobConstant.MESSAGE_200)
                .data(jobDto)
                .build(), HttpStatus.OK);
    }
    @Operation(summary = "Invoke list of job")
    @GetMapping
    public ResponseEntity<ResponseDto> getAllJobs(){
        List<JobWithCompanyDto> jobsDto=jobService.getAllJobs();
        return new ResponseEntity<>(ResponseDto.builder()
                .status(JobConstant.STATUS_200)
                .message(JobConstant.MESSAGE_200)
                .data(jobsDto)
                .build(), HttpStatus.OK);
    }
}
