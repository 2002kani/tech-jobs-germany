package com.studitech.jobservice.service;

import com.studitech.jobservice.dto.BulkIngestResponse;
import com.studitech.jobservice.dto.JobDto;
import com.studitech.jobservice.entities.EmbeddedArea;
import com.studitech.jobservice.entities.Job;
import com.studitech.jobservice.repository.JobRepository;
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
    private final JobRepository jobRepository;
    private final KafkaTemplate<String, JobDto> kafkaTemplate;

    @Override
    public BulkIngestResponse ingestJobs(List<JobDto> dtoJobs) {
        List<Job> jobsToCreate = new ArrayList<>();
        int received = dtoJobs.size();
        int created = 0;
        int skipped = 0;

        // Iterate through jobDtos and add them into entity list
        for(JobDto job : dtoJobs) {
            if(jobRepository.existsByRefnr(job.getRefnr())) {
                skipped++;
                continue; // ends loop and skips to the next job
            }
            jobsToCreate.add(toEntity(job));
            kafkaTemplate.send("job.created", job);
            log.info("Job created for kafka: {}", job);
        }
        jobRepository.saveAll(jobsToCreate);
        created = jobsToCreate.size();

        return BulkIngestResponse.builder()
                .received(received)
                .created(created)
                .skipped(skipped)
                .build();
    }

    private Job toEntity(JobDto dto) {
        EmbeddedArea area = EmbeddedArea.builder()
                .postalcode(dto.getArea().getPostalcode())
                .city(dto.getArea().getCity())
                .street(dto.getArea().getStreet())
                .region(dto.getArea().getRegion())
                .build();

        return Job.builder()
                .profession(dto.getProfession())
                .title(dto.getTitle())
                .refnr(dto.getRefnr())
                .extSource(dto.getExtSource())
                .area(area)
                .company(dto.getCompany())
                .publishDate(dto.getPublishDate())
                .modificationDate(dto.getModificationDate())
                .build();
    }
}
