package com.riskmanagement.back_riskmanagement.controller;


import com.riskmanagement.back_riskmanagement.dto.model.Threat;
import com.riskmanagement.back_riskmanagement.dto.response.ThreatResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.ThreatException;
import com.riskmanagement.back_riskmanagement.service.interfaces.ThreatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}