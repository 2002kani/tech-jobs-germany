package com.studitech.aggregationservice.mapper;

import com.studitech.aggregationservice.dto.JobArea;
import com.studitech.aggregationservice.dto.JobDto;
import com.studitech.aggregationservice.dto.bundesagentur.BundesagenturJobArea;

public interface IExternalJobMapper<T>{
    JobDto map(T externalJobs);
}
