package com.cloudinfo.review.messaging;

import com.cloudinfo.review.dto.ReviewDto;
import com.cloudinfo.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Review review){
        ReviewDto reviewDto=ReviewDto.builder()
                .id(review.getId())
                .title(review.getTitle())
                .reviewDescription(review.getReviewDescription())
                .rating(review.getRating())
                .companyId(review.getCompanyId())
                .build();
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewDto);
    }
}




