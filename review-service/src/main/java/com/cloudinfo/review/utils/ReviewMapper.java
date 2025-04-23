package com.cloudinfo.review.utils;

import com.cloudinfo.review.dto.ReviewDto;
import com.cloudinfo.review.entity.Review;

public class ReviewMapper {
    public static ReviewDto mapToDto(Review review){
        return ReviewDto.builder()
                .id(review.getId())
                .title(review.getTitle())
                .reviewDescription(review.getReviewDescription())
                .rating(review.getRating())
                .companyId(review.getCompanyId())
                .build();
    }
    public static Review mapToEntity(ReviewDto review){
        return Review.builder()
                .id(review.getId())
                .title(review.getTitle())
                .reviewDescription(review.getReviewDescription())
                .rating(review.getRating())
                .companyId(review.getCompanyId())
                .build();
    }
}
