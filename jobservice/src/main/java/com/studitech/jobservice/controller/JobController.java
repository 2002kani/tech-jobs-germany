package com.studitech.jobservice.controller;

import com.studitech.jobservice.dto.BulkIngestResponse;
import com.studitech.jobservice.dto.JobDto;
import com.studitech.jobservice.service.JobService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    private final JobService jobService;

    @PostMapping("/bulk")
    public ResponseEntity<BulkIngestResponse> ingestAggregatedJobs(@RequestBody List<JobDto> jobs){
        BulkIngestResponse resp = jobService.ingestJobs(jobs);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
