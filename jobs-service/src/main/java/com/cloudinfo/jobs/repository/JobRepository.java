package com.cloudinfo.jobs.repository;

import com.cloudinfo.jobs.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
