package com.studitech.aggregationservice.client;

import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJob;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJobResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
public class BundesagenturClient {
    private final RestTemplate restTemplate;
    private final String bundesagenturApiUrl;
    private final String bundesagenturApiKey;

    public BundesagenturClient(
            RestTemplate restTemplate,
            @Value("${bundesagentur.api.url}")  String bundesagenturApiUrl,
            @Value("${bundesagentur.api.key}") String bundesagenturApiKey
    ){
        this.restTemplate = restTemplate;
        this.bundesagenturApiUrl = bundesagenturApiUrl;
        this.bundesagenturApiKey = bundesagenturApiKey;
    }

    public List<BundesagenturJob> getBundesagenturJobs(){
        String url = UriComponentsBuilder
                .fromUriString(bundesagenturApiUrl)
                .queryParam("was", "software")
                .queryParam("angebotsart", "34")
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", bundesagenturApiKey);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<BundesagenturJobResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, BundesagenturJobResponse.class);

        log.info("BundesagenturJobs response: {}", response.getBody().getBundesagenturJobOffers());
        return response.getBody().getBundesagenturJobOffers();
    }
}
