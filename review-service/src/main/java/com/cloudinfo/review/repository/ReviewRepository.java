package com.cloudinfo.review.repository;

import com.cloudinfo.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM reviews r WHERE r.company_id=:companyId")
    List<Review> findReviewByCompanyId(@Param("companyId") Long companyId);
}

