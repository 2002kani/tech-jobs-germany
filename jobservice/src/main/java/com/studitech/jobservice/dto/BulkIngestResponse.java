package com.studitech.jobservice.dto;


public record BulkIngestResponse(
   Long received,
   Long created,
   Long skipped
) {}
