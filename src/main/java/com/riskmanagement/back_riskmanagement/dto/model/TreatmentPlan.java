package com.riskmanagement.back_riskmanagement.dto.model;
import com.riskmanagement.back_riskmanagement.dto.request.TreatmentPlanRequest;
import lombok.Data;

@Data
public class TreatmentPlan {
    private Integer PlanId;
    private String description;
    private String status;
    private Integer userId;
    private Boolean active;
    private Integer RiskId;

    public static TreatmentPlan fromRequest(TreatmentPlanRequest request) {
        TreatmentPlan plan = new TreatmentPlan();
        plan.setDescription(request.getDescription());
        plan.setStatus(request.getStatus());
        plan.setUserId(request.getUserId());
        plan.setActive(request.getActive());
        plan.setRiskId(request.getRiskId());
        plan.setPlanId(request.getPlanId());
        return plan;
    }

}

