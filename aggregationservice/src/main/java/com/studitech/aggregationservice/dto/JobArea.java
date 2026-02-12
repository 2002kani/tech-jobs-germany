package com.studitech.aggregationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobArea {
    private String postalcode;

    private String city;

    private String street;

    private String region;
}
