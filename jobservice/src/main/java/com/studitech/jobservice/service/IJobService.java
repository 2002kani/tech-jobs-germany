package com.studitech.jobservice.service;

import com.studitech.jobservice.dto.BulkIngestResponse;
import com.studitech.jobservice.dto.JobDto;

import java.util.List;

public interface IJobService {
    BulkIngestResponse ingestJobs(List<JobDto> jobs);
}
