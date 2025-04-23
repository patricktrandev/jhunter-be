package com.cloudinfo.company.clients;

import com.cloudinfo.company.dto.ReviewRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name="REVIEW-SERVICE", url="${review-service.url}")
@FeignClient(name="REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/api/v1/reviews/ratings")
    ResponseEntity<ReviewRating> getReviewRating(@RequestParam Long companyId);
}
