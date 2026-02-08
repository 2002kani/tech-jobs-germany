package com.studitech.aggregationservice.service;

import com.studitech.aggregationservice.client.BundesagenturClient;
import com.studitech.aggregationservice.dto.JobDto;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJob;
import com.studitech.aggregationservice.mapper.BundesagenturMapper;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AggregationService implements IAggregationService {
    private final BundesagenturClient bundesagenturClient;
    private final BundesagenturMapper bundesagenturMapper;

    @Scheduled(cron = "0 0 */6 * * *") // Every 6 hours
    public void aggregateJobs(){
        List<BundesagenturJob> bundesagenturJobs = bundesagenturClient.getBundesagenturJobs();

        List<JobDto> jobs = bundesagenturJobs.stream()
                .map(bundesagenturMapper::map)
                .toList();

        // TODO: Create JobServiceClient to send normalized jobs to the service
    }
}
