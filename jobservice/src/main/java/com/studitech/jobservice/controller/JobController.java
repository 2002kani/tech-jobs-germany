package com.studitech.jobservice.controller;

import com.studitech.jobservice.dto.JobDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @PostMapping("/bulk")
    public ResponseEntity<Void> ingestAggregatedJobs(@RequestBody List<JobDto> jobs){
        // read todo list
        return ResponseEntity.ok().build();
    }
}
