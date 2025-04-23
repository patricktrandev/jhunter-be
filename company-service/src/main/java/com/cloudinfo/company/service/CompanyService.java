package com.cloudinfo.company.service;

import com.cloudinfo.company.dto.CompanyDto;
import com.cloudinfo.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    void createCompany(CompanyDto companyDto);
    CompanyDto getCompanyById(Long id);
    void deleteCompany(Long id);
    List<CompanyDto> getAllCompanies();
    void updateCompany(Long id, CompanyDto companyDto);
    void updateCompanyRating(ReviewMessage reviewMessage);
}
