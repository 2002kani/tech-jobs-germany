package com.studitech.jobservice.repository;

import com.studitech.jobservice.dto.JobDto;
import com.studitech.jobservice.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    boolean existsByRefnr(String refnr); // TODO: If scaling: fix O(n) complexity of that
}
