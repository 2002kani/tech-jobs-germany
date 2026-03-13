package com.studitech.jobservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seen_job")
public class SeenJob {
    @Id
    @Column(name = "ref_nr", nullable = false)
    private String refnr;
}
