package com.jobfinder.aggregationservice.dto.bundesagentur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
