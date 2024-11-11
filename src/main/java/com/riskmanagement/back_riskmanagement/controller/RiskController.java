package com.riskmanagement.back_riskmanagement.controller;

import com.riskmanagement.back_riskmanagement.dto.model.Risk;
import com.riskmanagement.back_riskmanagement.dto.request.RiskRequest;
import com.riskmanagement.back_riskmanagement.dto.response.RiskResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.RiskException;
import com.riskmanagement.back_riskmanagement.service.interfaces.RiskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RiskController.RISK_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
public class RiskController {
    public static final String RISK_URI = "/api/v1/risk";

    @Autowired
    private RiskService riskService;

    @GetMapping
    public ResponseEntity<List<RiskResponse>> getAllRisks() {
        try{
            return ResponseEntity.ok(riskService.getAllRisks());
        }catch(Exception e){
            throw new RiskException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_013, e.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskResponse> getRiskById(@PathVariable Integer id) {
        Risk risk = riskService.findRiskById(id);
        RiskResponse riskResponse = RiskResponse.fromRisk(risk);
        return ResponseEntity.ok(riskResponse);
    }

    @PostMapping
    public ResponseEntity<RiskResponse> createRisk(@RequestBody RiskRequest riskRequest) {
        Risk risk = riskService.createRisk(Risk.fromRiskRequest(riskRequest));
        RiskResponse riskResponse = RiskResponse.fromRisk(risk);
        return ResponseEntity.ok(riskResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskResponse> updateRisk(@PathVariable Integer id, @RequestBody RiskRequest riskRequest) {
        Risk risk = riskService.updateRisk(id, Risk.fromRiskRequest(riskRequest));
        RiskResponse updatedRisk = RiskResponse.fromRisk(risk);
        return ResponseEntity.ok(updatedRisk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRisk(@PathVariable Integer id) {
        riskService.deleteRisk(id);
        return ResponseEntity.noContent().build();
    }
}
