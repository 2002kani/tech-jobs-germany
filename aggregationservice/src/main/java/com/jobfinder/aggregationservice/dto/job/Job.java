package com.jobfinder.aggregationservice.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobfinder.aggregationservice.dto.bundesagentur.JobArea;
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
    @JsonProperty("beruf")
    private String profession;

    @JsonProperty("titel")
    private String title;

    private String refnr;

    @JsonProperty("arbeitsort")
    private JobArea area;

    @JsonProperty("arbeitgeber")
    private String company;

    @JsonProperty("aktuelleVeroeffentlichungsdatum")
    private LocalDate publishDate;

    @JsonProperty("modifikationsTimestamp")
    private LocalDateTime modificationDate;
}
