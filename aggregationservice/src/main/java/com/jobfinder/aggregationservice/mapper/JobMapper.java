package com.jobfinder.aggregationservice.mapper;

import com.jobfinder.aggregationservice.dto.bundesagentur.BundesagenturJob;
import com.jobfinder.aggregationservice.dto.job.Job;

public class JobMapper {
    public static Job mapToJob(BundesagenturJob job){
        return Job.builder()
                .profession(job.getProfession())
                .title(job.getTitle())
                .refnr(job.getRefnr())
                .area(job.getArea())
                .company(job.getCompany())
                .publishDate(job.getPublishDate())
                .modificationDate(job.getModificationDate())
                .build();
    }
}
