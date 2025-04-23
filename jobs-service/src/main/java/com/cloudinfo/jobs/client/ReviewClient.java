package com.cloudinfo.jobs.client;

import com.cloudinfo.jobs.dto.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "REVIEW-SERVICE", url = "${review-service.url}")
@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/api/v1/reviews")
    List<ReviewDto> getReviews(@RequestParam Long companyId);
}
