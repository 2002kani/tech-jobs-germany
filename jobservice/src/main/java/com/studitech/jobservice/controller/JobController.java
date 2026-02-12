package com.studitech.jobservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @PostMapping("/bulk")
    public ResponseEntity<Void> ingestAggregatedJobs(){
        // read todo list
        return ResponseEntity.ok().build();
    }
}
