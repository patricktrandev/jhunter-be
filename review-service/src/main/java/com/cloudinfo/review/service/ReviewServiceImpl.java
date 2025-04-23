package com.cloudinfo.review.service;

import com.cloudinfo.review.client.CompanyClient;
import com.cloudinfo.review.dto.CompanyDto;
import com.cloudinfo.review.dto.ReviewCompanyDto;
import com.cloudinfo.review.dto.ReviewDto;
import com.cloudinfo.review.dto.ReviewRating;
import com.cloudinfo.review.entity.Review;
import com.cloudinfo.review.exception.ResourceNotFoundException;
import com.cloudinfo.review.messaging.ReviewMessageProducer;
import com.cloudinfo.review.repository.ReviewRepository;
import com.cloudinfo.review.utils.ReviewMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyClient companyClient;
    private final ReviewMessageProducer reviewMessageProducer;
    //private final CompanyRepository companyRepository;

    @Override
    @Transactional
    public void createReview(ReviewDto reviewDto) {
      //  Company company =companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company","id", companyId));
        Review review= ReviewMapper.mapToEntity(reviewDto);
       // review.setCompany(company);
        Review response=reviewRepository.save(review);
        reviewMessageProducer.sendMessage(response);
    }

    @Override
    public List<ReviewDto> getReviewsByCompany(Long companyId) {
        List<ReviewDto> response = new ArrayList<>();
        List<Review> reviews=reviewRepository.findReviewByCompanyId(companyId);
        for(Review r: reviews){
            response.add(ReviewMapper.mapToDto(r));
        }
        return response;
    }

    @Override
    public ReviewCompanyDto getReviewById(Long id) {
       Review review= reviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Review","id",id));
       CompanyDto companyDto =companyClient.getCompany(review.getCompanyId());
        return ReviewCompanyDto.builder()
                .reviewDto(ReviewMapper.mapToDto(review))
                .companyDto(companyDto)
                .build();
    }

    @Override
    @Transactional
    public ReviewRating updateCompanyRatingByReview(Long companyId) {
        List<Review> reviews= reviewRepository.findReviewByCompanyId(companyId);
        double ratings= reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
        return ReviewRating.builder()
                .rating(ratings)
                .companyId(companyId)
                .build();
    }

}