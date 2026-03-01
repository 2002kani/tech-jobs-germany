package com.studitech.aggregationservice.client;

import com.studitech.aggregationservice.dto.BulkIngestResponse;
import com.studitech.aggregationservice.dto.JobDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
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
        ResponseEntity<BulkIngestResponse> resp = restTemplate.postForEntity(jobServiceUrl, jobs, BulkIngestResponse.class);
        BulkIngestResponse body = resp.getBody();

        if(body != null) {
            log.info("Jobs sent. Received: {}, created: {}, skipped: {}.", body.received(), body.created(), body.skipped());
        }
    }
}
