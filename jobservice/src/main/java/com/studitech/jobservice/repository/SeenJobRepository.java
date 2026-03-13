package com.studitech.jobservice.repository;

import com.studitech.jobservice.entities.SeenJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeenJobRepository extends JpaRepository<SeenJob, String> {
    boolean existsByRefnr(String refnr);
}
