package com.studitech.aggregationservice.dto;

public record BulkIngestResponse(
        Long received,
        Long created,
        Long skipped
) {}
