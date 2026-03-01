package com.studitech.jobservice.dto;

import lombok.Builder;

@Builder
public record BulkIngestResponse(
   long received,
   long created,
   long skipped
) {}
