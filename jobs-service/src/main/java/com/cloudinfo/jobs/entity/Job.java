package com.cloudinfo.jobs.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Job extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(name = "min_salary")
    private String minSalary;
    @Column(name = "max_salary")
    private String maxSalary;
    private String location;
    @Column(name = "company_id")
    private Long companyId;
}
