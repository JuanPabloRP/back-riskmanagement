package com.riskmanagement.back_riskmanagement.exception.riskmanagement;

import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;

public class RiskException  extends BusinessException{
    private final ExceptionCodesRiskManagementDatabase codeType;

    public RiskException(ExceptionCodesRiskManagementDatabase codeType, String exceptionMessage) {
        super(codeType.name(), codeType.getDescription(), exceptionMessage);
        this.codeType = codeType;

    }
}
