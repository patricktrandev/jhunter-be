package com.cloudinfo.review.service;

import com.cloudinfo.review.dto.ReviewCompanyDto;
import com.cloudinfo.review.dto.ReviewDto;
import com.cloudinfo.review.dto.ReviewRating;

import java.util.List;

public interface ReviewService {
    void createReview(ReviewDto reviewDto);
    List<ReviewDto> getReviewsByCompany(Long companyId);
    ReviewCompanyDto getReviewById(Long id);
    ReviewRating updateCompanyRatingByReview(Long companyId);
}

