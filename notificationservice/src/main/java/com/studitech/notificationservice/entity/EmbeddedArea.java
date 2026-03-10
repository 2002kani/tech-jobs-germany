package com.studitech.notificationservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class EmbeddedArea {
    @Column(name = "postalcode")
    private String postalcode;

    private String city;

    private String street;

    private String region;
}
