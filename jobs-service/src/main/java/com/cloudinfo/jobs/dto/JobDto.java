package com.cloudinfo.jobs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDto {
    private Long id;
    private String title;
    private String description;
    @JsonProperty("min_salary")
    private String minSalary;
    @JsonProperty("max_salary")
    private String maxSalary;
    private String location;
    @JsonProperty("company_id")
    private Long companyId;
}
