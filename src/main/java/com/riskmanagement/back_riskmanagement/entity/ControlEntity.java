package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "control")
@Getter
@Builder
public class ControlEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    private Integer id;

    @Column(name = "control_name")
    private String name;

    @Column(name = "control_type")
    private String type;

    @Column(name = "control_description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private StatusEntity statusId;
    







}
