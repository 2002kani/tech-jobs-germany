package com.studitech.aggregationservice.service;

import com.studitech.aggregationservice.client.BundesagenturClient;
import com.studitech.aggregationservice.client.JobServiceClient;
import com.studitech.aggregationservice.dto.JobDto;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJob;
import com.studitech.aggregationservice.mapper.BundesagenturMapper;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AggregationService implements IAggregationService {
    private final BundesagenturClient bundesagenturClient;
    private final BundesagenturMapper bundesagenturMapper;
    private final JobServiceClient jobServiceClient;

    // @Scheduled(cron = "0 0 */6 * * *") // Every 6 hours
    // @Scheduled(cron = "*/10 * * * * *") // TEST for log
    public void aggregateJobs(){
        List<BundesagenturJob> bundesagenturJobs = bundesagenturClient.getBundesagenturJobs();

        List<JobDto> jobs = bundesagenturJobs.stream()
                .map(bundesagenturMapper::map)
                .toList();

        if(jobs.isEmpty()) return;

        jobServiceClient.sendJobs(jobs);
    }
}
