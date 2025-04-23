package com.cloudinfo.jobs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    private Long id;
    private String title;
    @JsonProperty("review_description")
    private String reviewDescription;
    private double rating;
    @JsonProperty("company_id")
    private Long companyId;
}
