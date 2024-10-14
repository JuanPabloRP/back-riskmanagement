package com.riskmanagement.back_riskmanagement.exception.riskmanagement;


import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String message;
    private final String code;

    public BusinessException(final String code, final String message, final String messageException) {
        super(message);
        this.code = code;
        this.message = String.format("%s %s", message, messageException);
    }
}
