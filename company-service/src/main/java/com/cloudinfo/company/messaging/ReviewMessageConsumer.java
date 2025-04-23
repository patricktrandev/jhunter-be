package com.cloudinfo.company.messaging;

import com.cloudinfo.company.dto.ReviewMessage;
import com.cloudinfo.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ReviewMessageConsumer {
    private final CompanyService companyService;


    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){

        companyService.updateCompanyRating(reviewMessage);
    }
}
