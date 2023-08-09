package com.cobean.backend.common.exception;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Slf4j
public enum ExceptionType {

    BEAN_NOT_FOUND(HttpStatus.NOT_FOUND, "BE001", "해당 Bean을 찾을 수 없습니다."),
    ALREADY_EXIST_BEAN(HttpStatus.ALREADY_REPORTED, "BE002", "이미 등록된 Bean입니다."),
    ROASTERS_NOT_FOUND(HttpStatus.NOT_FOUND, "RO001", "해당 Roasters를 찾을 수 없습니다."),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "UR001", "해당 User의 이름을 찾을 수 없습니다.");


    private final HttpStatus httpStatus;

    private final String errorCode;

    private final String message;

}
