package com.riskmanagement.back_riskmanagement.controller;
import com.riskmanagement.back_riskmanagement.dto.model.TreatmentPlan;
import com.riskmanagement.back_riskmanagement.dto.request.TreatmentPlanRequest;
import com.riskmanagement.back_riskmanagement.dto.response.TreatmentPlanResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.TreatmentPlanException;
import com.riskmanagement.back_riskmanagement.service.interfaces.TreatmentPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = PlanController.PLAN_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanController {
    public static final String PLAN_URI = "/api/v1/plans";

    @Autowired
    TreatmentPlanService treatmentPlanService;

    @GetMapping()
    public ResponseEntity<List<TreatmentPlanResponse>> getAllRisk() {
        try {
            List<TreatmentPlanResponse> plans = treatmentPlanService
                    .findAll()
                    .stream()
                    .map(TreatmentPlanResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(plans);
        } catch (Exception e) {
            throw new TreatmentPlanException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_023, e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<TreatmentPlanResponse>> getAllPlans() {
        try {
            List<TreatmentPlanResponse> plans = treatmentPlanService
                    .findAll()
                    .stream()
                    .map(TreatmentPlanResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(plans);
        } catch (Exception e) {
            throw new TreatmentPlanException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_018, e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TreatmentPlanResponse> getPlanById(@PathVariable Integer id) {
        try {
            TreatmentPlanResponse planResponse = TreatmentPlanResponse.fromModel(treatmentPlanService.findById(id));
            return ResponseEntity.ok(planResponse);
        } catch (TreatmentPlanException e) {
           throw new TreatmentPlanException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_019, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<TreatmentPlanResponse> createPlan(@RequestBody TreatmentPlanRequest planRequest) {
        try {
            TreatmentPlan plan = TreatmentPlan.fromRequest(planRequest);
            TreatmentPlanResponse planResponse = TreatmentPlanResponse.fromModel(plan);
            return ResponseEntity.ok(planResponse);
        } catch (TreatmentPlanException e) {
            throw new TreatmentPlanException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_020, e.getMessage());
        }
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<TreatmentPlanResponse> updatePlan(@PathVariable Integer id, @RequestBody TreatmentPlanRequest planRequest) {
        try {
            TreatmentPlan plan = treatmentPlanService.update(id, TreatmentPlan.fromRequest(planRequest));
            TreatmentPlanResponse planResponse = TreatmentPlanResponse.fromModel(plan);
            return ResponseEntity.ok(planResponse);
        } catch (TreatmentPlanException e) {
            throw new TreatmentPlanException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_021, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TreatmentPlanResponse> deletePlan(@PathVariable Integer id) {
        try {
            TreatmentPlan plan = treatmentPlanService.delete(id);
            TreatmentPlanResponse planResponse = TreatmentPlanResponse.fromModel(plan);
            return ResponseEntity.ok(planResponse);
        } catch (TreatmentPlanException e) {
            throw new TreatmentPlanException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_022, e.getMessage());
        }
    }
}
