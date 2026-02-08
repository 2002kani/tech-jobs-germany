package com.studitech.aggregationservice.mapper;

import com.studitech.aggregationservice.dto.JobDto;

public interface IExternalJobMapper<T>{
    JobDto map(T externalJobs);
}
