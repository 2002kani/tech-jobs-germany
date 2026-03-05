package com.studitech.jobservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class EmbeddedArea {
    @Column(name = "postalcode")
    private String postalcode;

    private String city;

    private String street;

    private String region;
}
