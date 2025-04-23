package com.cloudinfo.company.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company",uniqueConstraints = @UniqueConstraint(columnNames = "company_name"))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Company extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "company_description")
    private String companyDescription;
    @Column(name = "company_address", nullable = false)
    private String companyAddress;
    private double rating;
//    @JsonIgnore
//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
//    private List<Job> jobs;
//    @JsonIgnore
//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
//    private List<Review> reviews;

}