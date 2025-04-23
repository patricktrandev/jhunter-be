package com.cloudinfo.jobs.utils;

import com.cloudinfo.jobs.dto.JobDto;
import com.cloudinfo.jobs.entity.Job;

public class JobMapper {
    public static JobDto mapToDto(Job job){
        return JobDto.builder()
                .id(job.getId())
                .title(job.getTitle())
                .description(job.getDescription())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .location(job.getLocation())
                .companyId(job.getCompanyId())
                .build();
    }
    public static Job mapToEntity(JobDto jobDto){
        return Job.builder()
                .id(jobDto.getId())
                .title(jobDto.getTitle())
                .description(jobDto.getDescription())
                .minSalary(jobDto.getMinSalary())
                .maxSalary(jobDto.getMaxSalary())
                .location(jobDto.getLocation())
                .companyId(jobDto.getCompanyId())
                .build();
    }
}
