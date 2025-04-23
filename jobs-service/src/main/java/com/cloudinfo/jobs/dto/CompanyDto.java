package com.cloudinfo.jobs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private Long id;
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("company_description")
    private String companyDescription;
    @JsonProperty("company_address")
    private String companyAddress;
}
