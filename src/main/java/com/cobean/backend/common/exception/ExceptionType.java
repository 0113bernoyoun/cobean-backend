package com.cobean.backend.common.exception;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ExceptionType {

    BEAN_NOT_FOUND(HttpStatus.NOT_FOUND, "BE001", "해당 Bean을 찾을 수 없습니다."),
    ALREADY_EXIST_BEAN(HttpStatus.ALREADY_REPORTED, "BE002", "이미 등록된 Bean입니다.");


    private final HttpStatus httpStatus;

    private final String errorCode;

    private final String message;

}
