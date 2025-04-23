package com.cloudinfo.review.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewRating {
    private double rating;
    @JsonProperty("company_id")
    private long companyId;
}
