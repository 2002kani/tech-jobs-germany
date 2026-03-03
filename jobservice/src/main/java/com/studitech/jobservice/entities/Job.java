package com.studitech.jobservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profession;

    private String title;

    @Column(name = "ref_nr", unique = true)
    private String refnr;

    @Column(name = "external_source")
    private String extSource;

    @Embedded
    private EmbeddedArea area;

    private String company;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
}
