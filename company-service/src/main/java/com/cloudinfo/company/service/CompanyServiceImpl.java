package com.cloudinfo.company.service;


import com.cloudinfo.company.clients.ReviewClient;
import com.cloudinfo.company.dto.CompanyDto;
import com.cloudinfo.company.dto.ReviewMessage;
import com.cloudinfo.company.dto.ReviewRating;
import com.cloudinfo.company.entity.Company;
import com.cloudinfo.company.exception.ResourceAlreadyExist;
import com.cloudinfo.company.exception.ResourceNotFoundException;
import com.cloudinfo.company.repository.CompanyRepository;
import com.cloudinfo.company.utils.CompanyMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    private final ReviewClient reviewClient;
    @Override
    @Transactional
    public void createCompany(CompanyDto companyDto) {
        boolean check= companyRepository.existsByCompanyName(companyDto.getCompanyName());
        if(check){
            throw new ResourceAlreadyExist("Company name already exists!");
        }
        Company company=CompanyMapper.mapToEntity(companyDto);
        company.setRating(0.0);
        companyRepository.save(company);

    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        Company company=companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company", "id", id));
        return CompanyMapper.mapToDto(company);
    }

    @Override
    public void deleteCompany(Long id) {

    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies=companyRepository.findAll();
        List<CompanyDto> response= new ArrayList<>();
        for(Company c: companies){
            response.add(CompanyMapper.mapToDto(c));
        }
        return response;
    }

    @Override
    @Transactional
    public void updateCompany(Long id, CompanyDto companyDto) {
        Company company=companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company", "id", id));
        company.setCompanyDescription(companyDto.getCompanyDescription());
        company.setCompanyAddress(companyDto.getCompanyAddress());
        companyRepository.save(company);
    }

    @Override
    @Transactional
    public void updateCompanyRating(ReviewMessage reviewMessage) {

        Company company=companyRepository.findById(reviewMessage.getCompanyId()).orElseThrow(()-> new ResourceNotFoundException("Company", "id", reviewMessage.getCompanyId()));
        ReviewRating reviewRating =reviewClient.getReviewRating(reviewMessage.getCompanyId()).getBody();
        company.setRating(reviewRating.getRating());
        companyRepository.save(company);
    }
}