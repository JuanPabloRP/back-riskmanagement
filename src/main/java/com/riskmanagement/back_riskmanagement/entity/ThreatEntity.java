package com.riskmanagement.back_riskmanagement.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Table(name = "threat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThreatEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "threat_id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "threat_name")
    private String name;

    @Column(name = "threat_description")
    private String description;

    @Column(name = "threat_type")
    private String type;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "creation_date", insertable=false, updatable=false)
    private LocalDate creationDate;

    @Column(name = "modification_date", insertable=false, updatable=false)
    private LocalDate modificationDate;
}