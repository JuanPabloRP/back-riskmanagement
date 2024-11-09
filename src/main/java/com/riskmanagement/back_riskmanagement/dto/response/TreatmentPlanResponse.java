package com.riskmanagement.back_riskmanagement.dto.response;
import com.riskmanagement.back_riskmanagement.dto.model.TreatmentPlan;
import lombok.Data;
//Pendiente
@Data
public class TreatmentPlanResponse {
    private Integer planId;
    private Integer userId;
    private String description;
    private String status;
    private Boolean active;
    private Integer RiskId;


    public static TreatmentPlanResponse fromModel(TreatmentPlan plan) {
        TreatmentPlanResponse response = new TreatmentPlanResponse();
            response.setPlanId(plan.getPlanId());
            response.setUserId(plan.getUserId());
            response.setDescription(plan.getDescription());
            response.setStatus(plan.getStatus());
            response.setActive(plan.getActive());
            response.setActive(plan.getActive());
            response.setRiskId(plan.getRiskId());

            return response;
    }
}
