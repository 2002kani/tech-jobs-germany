package com.studitech.notificationservice.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profession;

    private String title;

    @Column(name = "ref_nr", unique = true, nullable = false)
    private String refnr;

    @Column(name = "external_source")
    private String extSource;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalcode", column = @Column(name = "area_postal_code")),
            @AttributeOverride(name = "city",       column = @Column(name = "area_city")),
            @AttributeOverride(name = "street",     column = @Column(name = "area_street")),
            @AttributeOverride(name = "region",     column = @Column(name = "area_region"))
    })
    private EmbeddedArea area;

    private String company;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "modification_date")
    private LocalDateTime modificationDate;

    @Column(name = "email_sent")
    private boolean emailSent;
}
