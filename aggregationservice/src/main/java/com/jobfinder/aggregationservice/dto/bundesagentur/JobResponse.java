package com.jobfinder.aggregationservice.dto.bundesagentur;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
    @JsonProperty("stellenangebote")
    private List<Job> stellenangebote;
}
