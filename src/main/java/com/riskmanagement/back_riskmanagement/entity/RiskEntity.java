package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "risk")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RiskEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "risk_id")
    private Integer riskId;

    @Column(name = "risk_name", unique = true)
    @Setter
    private String riskName;
}