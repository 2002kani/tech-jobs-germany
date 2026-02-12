package com.studitech.aggregationservice.client;

import com.studitech.aggregationservice.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JobServiceClient {
    private final String jobServiceUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public JobServiceClient(RestTemplate restTemplate, @Value("${job.service.url}") String jobServiceUrl) {
        this.restTemplate = restTemplate;
        this.jobServiceUrl = jobServiceUrl;
    }

    public void sendJobs(List<JobDto> jobs) {
        restTemplate.postForEntity(jobServiceUrl, jobs, Void.class);
    }
}
