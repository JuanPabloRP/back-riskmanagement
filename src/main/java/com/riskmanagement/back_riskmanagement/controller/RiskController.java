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
@RequestMapping(value = UserController.USER_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
public class RiskController {
    public static final String USER_URI = "/api/v1/risk";
    
        @Autowired
        RiskService RiskService;

        @GetMapping()
    public ResponseEntity<List<RiskResponse>> getAllRoles() {
        try {
            List<RiskResponse> risk = RiskService
                    .findAll()
                    .stream()
                    .map(RiskResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(risk);
        }catch (Exception e){
            throw new RiskException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_013, e.getMessage()
            );
        }
    }

public class RiskController {

  

}
