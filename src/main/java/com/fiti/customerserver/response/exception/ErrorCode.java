package com.fiti.customerserver.response.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /*성공 1000*/
    SUCCESS(true, 1000, "요청에 성공하였습니다."),
    SAVE_AUTH(true, 1001, "인증 정보를 저장했습니다."),

    /*공통 2000*/
    INVALID_INPUT(false, 2000, "잘못된 입력값입니다."),

    /*유저 3000*/
    ACCOUNT_NOT_FOUND(false, 3001, "사용자를 찾을 수 없습니다."),

    /*서버, DB 4000*/
    DATABASE_ERROR(false, 4000, "DB에 문제가 발생했습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    ErrorCode(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

}
