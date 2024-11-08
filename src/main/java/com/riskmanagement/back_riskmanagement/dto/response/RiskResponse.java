package com.riskmanagement.back_riskmanagement.dto.response;

import com.riskmanagement.back_riskmanagement.entity.RiskEntity;
import com.riskmanagement.back_riskmanagement.dto.model.Risk;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskResponse {
    private Integer riskId;
    private String riskName;

    public static RiskResponse fromRisk(Risk risk) {
        return RiskResponse.builder()
                .riskId(risk.getRiskId())
                .riskName(risk.getRiskName())
                .build();
    }

    public static RiskResponse fromEntity(RiskEntity riskEntity) {
        return RiskResponse.builder()
                .riskId(riskEntity.getRiskId())
                .riskName(riskEntity.getRiskName())
                .build();
    }
}