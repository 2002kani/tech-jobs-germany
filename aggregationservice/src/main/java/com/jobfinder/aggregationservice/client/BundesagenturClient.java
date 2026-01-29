package com.jobfinder.aggregationservice.client;

import com.jobfinder.aggregationservice.dto.bundesagentur.BundesagenturJob;

import com.jobfinder.aggregationservice.dto.bundesagentur.JobResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

    public List<BundesagenturJob> getBundesagenturJobs() {
        final RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromUriString(apiUrl)
                .queryParam("was", "software")
                .queryParam("angebotsart", 34)
                .toUriString();

        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", apiKey);
        headers.set("Accept", "application/json");

        // Complete Http Entity (Header + Body)
        org.springframework.http.HttpEntity<Void> entity = new org.springframework.http.HttpEntity<>(headers);

        org.springframework.http.ResponseEntity<JobResponse> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, JobResponse.class);

        return response.getBody().getBundesagenturJobOffers();
    }

}


