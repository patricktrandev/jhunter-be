package com.cloudinfo.jobs.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobWithCompanyDto {
    private JobDto jobDto;
    private CompanyDto companyDto;

}
