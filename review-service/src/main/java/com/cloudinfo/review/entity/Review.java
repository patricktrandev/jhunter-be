package com.cloudinfo.review.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "review_description")
    private String reviewDescription;
    @Column(nullable = false)
    private double rating;
    @Column(name = "company_id")
    private Long companyId;

}

