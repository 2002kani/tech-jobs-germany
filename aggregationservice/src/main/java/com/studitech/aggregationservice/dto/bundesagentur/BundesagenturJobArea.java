package com.studitech.aggregationservice.dto.bundesagentur;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class BundesagenturJobArea {
    @JsonProperty("plz")
    private String postalcode;

    @JsonProperty("ort")
    private String city;

    @JsonProperty("strasse")
    private String street;

    private String region;
}
