package com.studitech.aggregationservice.dto.bundesagentur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class JobResponse {
    public List<BundesagenturJob> bundesagenturJobOffers;
}
