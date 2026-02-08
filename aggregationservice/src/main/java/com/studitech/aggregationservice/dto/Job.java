package com.studitech.aggregationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String profession;

    private String title;

    private String refnr;

    private JobArea area;

    private String company;

    private LocalDate publishDate;

    private LocalDateTime modificationDate;
}