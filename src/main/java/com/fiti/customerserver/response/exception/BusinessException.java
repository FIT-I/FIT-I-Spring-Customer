package com.fiti.customerserver.response.exception;

public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
