package com.studitech.aggregationservice.client;

import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJob;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJobResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class BundesagenturClient {
    @Value("${bundesagentur.api.url}")
    private String bundesagenturApiUrl;

    @Value("${bundesagentur.api.key}")
    private String bundesagenturApiKey;

    public List<BundesagenturJob> getBundesagenturJobs(){
        final RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromUriString(bundesagenturApiUrl)
                .queryParam("was", "software")
                .queryParam("angebotsart", "34")
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", bundesagenturApiKey);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<BundesagenturJobResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, BundesagenturJobResponse.class);

        return response.getBody().getBundesagenturJobOffers();
    }
}
