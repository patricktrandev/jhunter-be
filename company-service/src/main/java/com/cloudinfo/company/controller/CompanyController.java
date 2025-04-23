package com.cloudinfo.company.controller;

import com.cloudinfo.company.dto.CompanyDto;
import com.cloudinfo.company.dto.ResponseDto;
import com.cloudinfo.company.service.CompanyService;
import com.cloudinfo.company.utils.CompanyConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
@Tag(name = "CRUD REST API for Company Resource")
public class CompanyController {
    private final CompanyService companyService;
    private static Logger logger= LoggerFactory.getLogger(CompanyController.class);

    @Operation(summary = "Create new company")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Company created successfully"),
            @ApiResponse(responseCode = "500", description = "Http status Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<ResponseDto> createCompany(@Valid @RequestBody CompanyDto companyDto) {
        companyService.createCompany(companyDto);
        logger.info("Company created successfully.");
        return new ResponseEntity<>(ResponseDto.builder()
                .message(CompanyConstant.MESSAGE_201)
                .status(CompanyConstant.STATUS_201)
                .build(), HttpStatus.CREATED);
    }
    @Operation(summary = "Get company by id")
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        CompanyDto company = companyService.getCompanyById(id);
        return ResponseEntity.ok(company);
    }
    @Operation(summary = "Get list of company")
    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }
    @Operation(summary = "Update company name")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto) {
        companyService.updateCompany(id, companyDto);
        return new ResponseEntity<>(ResponseDto.builder()
                .status(CompanyConstant.STATUS_200)
                .message(CompanyConstant.MESSAGE_UPDATE_COMPANY)
                .build(), HttpStatus.OK);
    }
}
