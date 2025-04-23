package com.cloudinfo.jobs.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Data
@Builder
public class JobCompanyReviewDto {
    private JobDto jobDto;
    private List<ReviewDto> reviewDtos;
    private CompanyDto companyDto;
}
