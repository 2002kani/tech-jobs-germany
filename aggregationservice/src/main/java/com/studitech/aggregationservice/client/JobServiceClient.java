package com.studitech.aggregationservice.client;

import com.studitech.aggregationservice.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JobServiceClient {
    private final String jobserviceUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public JobServiceClient(RestTemplate restTemplate, @Value("${jobservice.url}") String jobserviceUrl) {
        this.restTemplate = restTemplate;
        this.jobserviceUrl = jobserviceUrl;
    }

    public void sendJobs(List<JobDto> jobs) {
        restTemplate.postForEntity(jobserviceUrl, jobs, Void.class);
    }
}
