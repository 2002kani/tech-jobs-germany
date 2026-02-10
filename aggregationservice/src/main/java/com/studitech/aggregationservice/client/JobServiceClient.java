package com.studitech.aggregationservice.client;

import com.studitech.aggregationservice.dto.JobDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JobServiceClient {
    @Value("${jobservice.url}")
    private String jobserviceUrl;

    public ResponseEntity<Void> sendJobs(List<JobDto> jobs) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(jobserviceUrl, jobs, Void.class);
    }
}
