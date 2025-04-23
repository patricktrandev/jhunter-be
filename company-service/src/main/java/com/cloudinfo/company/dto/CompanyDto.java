package com.cloudinfo.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private Long id;
    @NotEmpty(message = "Company name cannot be empty")
    @JsonProperty("company_name")
    private String companyName;
    @NotEmpty(message = "Company description cannot be empty")
    @JsonProperty("company_description")
    private String companyDescription;
    @NotEmpty(message = "Company address cannot be empty")
    @JsonProperty("company_address")
    private String companyAddress;
    private double ratings;
}
