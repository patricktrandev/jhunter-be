package com.cloudinfo.review.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewCompanyDto {
    private CompanyDto companyDto;
    private ReviewDto reviewDto;
}
