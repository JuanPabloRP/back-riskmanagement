package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "status")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusEntity extends BaseEntity {
    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @Column(name = "status_name")
    private String statusName;


}
