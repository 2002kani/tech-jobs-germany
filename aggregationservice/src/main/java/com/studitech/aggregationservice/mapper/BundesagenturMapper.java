package com.studitech.aggregationservice.mapper;

import com.studitech.aggregationservice.dto.JobArea;
import com.studitech.aggregationservice.dto.JobDto;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJob;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJobArea;
import org.springframework.stereotype.Component;

@Component
public class BundesagenturMapper implements IExternalJobMapper<BundesagenturJob>{
    @Override
    public JobDto map(BundesagenturJob baJob) {
        return JobDto.builder()
                .profession(baJob.getProfession())
                .title(baJob.getTitle())
                .refnr(baJob.getRefnr())
                .extSource(baJob.getExtSource())
                .area(mapArea(baJob.getArea()))
                .company(baJob.getCompany())
                .publishDate(baJob.getPublishDate())
                .modificationDate(baJob.getModificationDate())
                .build();
    }

    private JobArea mapArea(BundesagenturJobArea baJobArea){
        if(baJobArea == null) return null;

        return JobArea.builder()
                .postalcode(baJobArea.getPostalcode())
                .city(baJobArea.getCity())
                .street(baJobArea.getStreet())
                .region(baJobArea.getRegion())
                .build();
    }
}
