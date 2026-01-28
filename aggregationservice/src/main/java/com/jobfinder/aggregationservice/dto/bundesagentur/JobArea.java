package com.jobfinder.aggregationservice.dto.bundesagentur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.jdi.PrimitiveValue;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobArea {
    @JsonProperty("plz")
    private String postalcode;

    @JsonProperty("ort")
    private String city;

    @JsonProperty("strasse")
    private String street;

    private String region;
}
