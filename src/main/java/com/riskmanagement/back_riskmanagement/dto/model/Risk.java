package com.riskmanagement.back_riskmanagement.dto.model;

import com.riskmanagement.back_riskmanagement.dto.request.RiskRequest;
import com.riskmanagement.back_riskmanagement.entity.RiskEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Risk {
    private Integer riskId;
    private String riskName;

    public static Risk fromEntity(RiskEntity riskEntity) {
        return Risk.builder()
                .riskId(riskEntity.getRiskId())
                .riskName(riskEntity.getRiskName())
                .build();
    }

    public static RiskEntity toEntity(Risk risk) {
        return RiskEntity.builder()
                .riskName(risk.getRiskName())
                .build();
    }

    public static Risk fromRiskRequest(RiskRequest riskRequest) {
        return Risk.builder()
                .riskName(riskRequest.getRiskName())
                .build();
    }
}

