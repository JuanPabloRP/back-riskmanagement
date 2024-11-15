package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asset")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private Integer assetId;

    @Column(name = "asset_name", unique = true)
    @Setter
    private String assetName;
}