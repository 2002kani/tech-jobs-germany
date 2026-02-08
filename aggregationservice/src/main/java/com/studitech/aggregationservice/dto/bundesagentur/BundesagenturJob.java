package com.studitech.aggregationservice.dto.bundesagentur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.studitech.aggregationservice.dto.JobArea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BundesagenturJob {
    @JsonProperty("beruf")
    private String profession;

    @JsonProperty("titel")
    private String title;

    private String refnr;

    @Builder.Default
    private String extSource = "bundesagentur";

    @JsonProperty("arbeitsort")
    private JobArea area;

    @JsonProperty("arbeitgeber")
    private String company;

    @JsonProperty("aktuelleVeroeffentlichungsdatum")
    private LocalDate publishDate;

    @JsonProperty("modifikationsTimestamp")
    private LocalDateTime modificationDate;
}