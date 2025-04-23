package com.cloudinfo.company.repository;

import com.cloudinfo.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCompanyName(String name);
    boolean existsByCompanyName(String name);
}
