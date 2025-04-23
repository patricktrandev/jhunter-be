package com.cloudinfo.review.client;

import com.cloudinfo.review.dto.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "COMPANY-SERVICE", url = "${company-service.url}")
@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {
    @GetMapping("/api/v1/companies/{id}")
    CompanyDto getCompany(@PathVariable Long id);
}
