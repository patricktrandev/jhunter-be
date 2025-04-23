package com.cloudinfo.company.utils;

import com.cloudinfo.company.dto.CompanyDto;
import com.cloudinfo.company.entity.Company;

public class CompanyMapper {
    public static CompanyDto mapToDto(Company company){
        return CompanyDto.builder()
                .companyName(company.getCompanyName())
                .id(company.getId())
                .companyDescription(company.getCompanyDescription())
                .companyAddress(company.getCompanyAddress())
                .ratings(company.getRating())
                .build();
    }
    public static Company mapToEntity(CompanyDto companyDto){
        return Company.builder()
                .companyName(companyDto.getCompanyName())
                .id(companyDto.getId())
                .companyDescription(companyDto.getCompanyDescription())
                .companyAddress(companyDto.getCompanyAddress())
                .rating(companyDto.getRatings())
                .build();
    }
}
