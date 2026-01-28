package com.jobfinder.aggregationservice.client;

import com.jobfinder.aggregationservice.entity.Job;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class BundesagenturClient {
    @Value("${bundesagentur.api.url}")
    String apiUrl;

    @Value("${bundesagentur.api.key}")
    String apiKey;

    public List<Job> getBundesagenturJobs() {
        final RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromUriString(apiUrl)
                .queryParam("was", "software")
                .queryParam("angebotsart", 34)
                .toUriString();

        
    }

}


