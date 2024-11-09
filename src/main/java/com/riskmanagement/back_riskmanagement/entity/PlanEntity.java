package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "treatment_plan")
public class PlanEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column(name = "risk_id", nullable = false)
    private Integer risk_id;

    //	risk_id INTEGER
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "modification_date", nullable = false)
    private LocalDateTime modificationDate;
}
