package com.studitech.aggregationservice.service;

import com.studitech.aggregationservice.client.BundesagenturClient;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJob;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AggregationService implements IAggregationService {
    private final BundesagenturClient bundesagenturClient;

    @Scheduled(cron = "0 0 */6 * * *") // Every 6 hours
    public void aggregateJobs(){
        List<BundesagenturJob> bundesagenturJobs = bundesagenturClient.getBundesagenturJobs();

    }
}
