package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.Risk;
import com.riskmanagement.back_riskmanagement.dto.request.RiskRequest;
import com.riskmanagement.back_riskmanagement.dto.response.RiskResponse;

import java.util.List;

public interface RiskService {
    Risk findRiskById(Integer id);
    Risk createRisk(Risk risk);
    Risk updateRisk(Integer id, Risk risk);
    void deleteRisk(Integer id);
    List<RiskResponse> getAllRisks();
}
