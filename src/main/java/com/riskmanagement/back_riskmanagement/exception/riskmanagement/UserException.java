package com.riskmanagement.back_riskmanagement.exception.riskmanagement;

import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodes;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import lombok.Getter;

@Getter
public class UserException extends BusinessException{
    private final ExceptionCodesRiskManagementDatabase codeType;

    public UserException(ExceptionCodesRiskManagementDatabase codeType, String exceptionMessage) {
        super(codeType.name(), codeType.getDescription(), exceptionMessage);
        this.codeType = codeType;
    }
}



