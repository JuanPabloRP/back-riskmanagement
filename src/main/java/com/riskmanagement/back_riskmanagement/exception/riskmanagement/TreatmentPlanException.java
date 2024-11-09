package com.riskmanagement.back_riskmanagement.exception.riskmanagement;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import lombok.Getter;

@Getter
public class TreatmentPlanException extends RuntimeException {
    private final ExceptionCodesRiskManagementDatabase codeType;

    public TreatmentPlanException(ExceptionCodesRiskManagementDatabase codeType, String message) {
        super(message);
        this.codeType = codeType;
    }
}
