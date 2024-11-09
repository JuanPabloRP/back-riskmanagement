package com.riskmanagement.back_riskmanagement.dto.request;
import lombok.Data;

@Data
public class TreatmentPlanRequest {
    private Integer userId;
    private String description;
    private String status;
    private Boolean active;
    private Integer RiskId;
    private Integer PlanId;



    public Integer getUserId() { return userId; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public Boolean isActive() { return active; }
    public Integer getRiskId() { return RiskId; }
    public Integer getPlanId() {return PlanId;}
}
