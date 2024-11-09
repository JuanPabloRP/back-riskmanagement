package com.riskmanagement.back_riskmanagement.controller;


import com.riskmanagement.back_riskmanagement.dto.model.Threat;
import com.riskmanagement.back_riskmanagement.dto.response.ThreatResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.ThreatException;
import com.riskmanagement.back_riskmanagement.service.interfaces.ThreatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = ThreatController.THREAT_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ThreatController {
    public static final String THREAT_URI = "/api/v1/threats";

    @Autowired
    private ThreatService threatService;

    @GetMapping
    public ResponseEntity<List<ThreatResponse>> getAllThreats() {
        try {
            List<ThreatResponse> threats = threatService.findAll()
                    .stream()
                    .map(ThreatResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(threats);
        } catch (Exception e) {
            throw new ThreatException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_013, e.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThreatResponse> getThreatById(@PathVariable Integer id) {
        try {
            Threat threat = threatService.findThreatById(id);
            if (threat == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(ThreatResponse.fromModel(threat));
        } catch (Exception e) {
            throw new ThreatException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_013, e.getMessage()
            );
        }
    }


    @PostMapping
    public ResponseEntity<ThreatResponse> createThreat(@RequestBody @Valid Threat threat) {
        try {
            Threat createdThreat = threatService.create(threat);
            ThreatResponse response = ThreatResponse.fromModel(createdThreat);
            return ResponseEntity.status(201).body(response);
        } catch (Exception e) {
            throw new ThreatException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_014, e.getMessage()
            );
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThreat(@PathVariable Integer id) {
        try {
            Threat deletedThreat = threatService.delete(id);

            if (deletedThreat != null)
                return ResponseEntity.noContent().build();
            else
                return ResponseEntity.notFound().build();
        } catch (Exception e) {
            throw new ThreatException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_015, e.getMessage()
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<ThreatResponse> updateThreat(@PathVariable Integer id, @RequestBody @Valid Threat threat) {
        try {
            Threat updatedThreat = threatService.update(id, threat);
            if (updatedThreat != null) {
                ThreatResponse response = ThreatResponse.fromModel(updatedThreat);
                return ResponseEntity.ok(response);

            } else {
                throw new ThreatException(
                        ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_015,
                        "Threat not found for update"
                );
            }
        } catch (Exception e) {
            throw new ThreatException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_015, e.getMessage()
            );
        }
    }
}