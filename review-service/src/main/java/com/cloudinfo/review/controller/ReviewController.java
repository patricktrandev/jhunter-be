package com.cloudinfo.review.controller;

import com.cloudinfo.review.dto.ResponseDto;
import com.cloudinfo.review.dto.ReviewCompanyDto;
import com.cloudinfo.review.dto.ReviewDto;
import com.cloudinfo.review.dto.ReviewRating;
import com.cloudinfo.review.messaging.ReviewMessageProducer;
import com.cloudinfo.review.service.ReviewService;
import com.cloudinfo.review.utils.ReviewConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Tag(name = "CRUD REST API for Review Resource")
public class ReviewController {


    private final ReviewService reviewService;

    @Operation(summary = "Create new review about company")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Review created successfully"),
            @ApiResponse(responseCode = "500", description = "Http status Internal Server Error")
    })
    @PostMapping("/reviews")
    public ResponseEntity<ResponseDto> createReview(@Valid @RequestBody ReviewDto reviewDto){
        reviewService.createReview(reviewDto);

        return new ResponseEntity<>(ResponseDto.builder()
                .status(ReviewConstant.STATUS_200)
                .message(ReviewConstant.MESSAGE_200)
                .build(), HttpStatus.CREATED);
    }
    @Operation(summary = "Invoke all reviews by company id")
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> getAllReviews(@Valid @RequestParam @NotNull(message = "Company id cannot be empty") Long companyId){
        List<ReviewDto> reviews=reviewService.getReviewsByCompany(companyId);
        return ResponseEntity.ok(reviews);
    }
    @Operation(summary = "Invoke a review by id")
    @GetMapping("/reviews/{id}")
    public ResponseEntity<ResponseDto> getReviewById(@PathVariable Long id){
        ReviewCompanyDto review=reviewService.getReviewById(id);
        return ResponseEntity.ok(ResponseDto.builder()
                .status(ReviewConstant.STATUS_200)
                .message(ReviewConstant.MESSAGE_200)
                .data(review)
                .build());
    }
    @Operation(summary = "Invoke company rating")
    @GetMapping("/reviews/ratings")
    public ResponseEntity<ResponseDto> getReviewRatingByCompany(@RequestParam Long companyId){
        ReviewRating response= reviewService.updateCompanyRatingByReview(companyId);
        return ResponseEntity.ok(ResponseDto.builder()
                .status(ReviewConstant.STATUS_200)
                .message(ReviewConstant.MESSAGE_200)
                        .data(response)
                .build());
    }
}