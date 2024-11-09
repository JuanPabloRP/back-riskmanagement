package com.riskmanagement.back_riskmanagement.exception.riskmanagement;

import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;

public class ControlException extends BusinessException{
    private final ExceptionCodesRiskManagementDatabase codeType;

    public ControlException(ExceptionCodesRiskManagementDatabase codeType, String exceptionMessage) {
        super(codeType.name(), codeType.getDescription(), exceptionMessage);
        this.codeType = codeType;
    }

}
