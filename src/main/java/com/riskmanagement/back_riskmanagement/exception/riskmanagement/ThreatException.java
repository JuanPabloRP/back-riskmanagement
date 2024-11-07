package com.riskmanagement.back_riskmanagement.exception.riskmanagement;

import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import lombok.Getter;

@Getter
public class ThreatException extends RuntimeException {
    private final String code;
    private final String message;

    public ThreatException(ExceptionCodesRiskManagementDatabase exceptionCode, String message) {
        super(message);
        this.code = exceptionCode.name();
        this.message = exceptionCode.getDescription() + ": " + message;
    }
}