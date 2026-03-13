package com.studitech.jobservice.service;

import com.studitech.jobservice.dto.BulkIngestResponse;
import com.studitech.jobservice.dto.JobDto;
import com.studitech.jobservice.entities.SeenJob;
import com.studitech.jobservice.repository.SeenJobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class JobService implements IJobService {
    private final SeenJobRepository seenJobRepository;
    private final KafkaTemplate<String, JobDto> kafkaTemplate;

    @Override
    public BulkIngestResponse ingestJobs(List<JobDto> dtoJobs) {
        List<SeenJob> seenJobs = new ArrayList<>();
        int received = dtoJobs.size();
        int created = 0;
        int skipped = 0;

        // Iterate through jobDtos and add them into entity list
        for(JobDto job : dtoJobs) {
            if(seenJobRepository.existsByRefnr(job.getRefnr())) {
                skipped++;
                continue; // ends loop and skips to the next job
            }
            seenJobs.add(toSeenjobs(job));
            kafkaTemplate.send("job.created", job);
            log.info("Job created for kafka: {}", job);
        }
        seenJobRepository.saveAll(seenJobs);
        created = seenJobs.size();

        return BulkIngestResponse.builder()
                .received(received)
                .created(created)
                .skipped(skipped)
                .build();
    }

    private SeenJob toSeenjobs(JobDto job) {
        return SeenJob.builder()
                .refnr(job.getRefnr())
                .build();
    }
}
