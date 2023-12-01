package com.dailybudget.budgetapi.domain.shared.utils;

import org.springframework.http.HttpStatus;

public enum StatusCode {

    USER_WAS_FOUND(HttpStatus.FOUND,"The client was found"),
    USER_WAS_NOT_FOUND(HttpStatus.NOT_FOUND,"The client was not found"),
    ERROR_CONSULTING_THE_USER(HttpStatus.BAD_REQUEST,"Error consulting the user"),
    USER_WAS_NOT_REGISTERED(HttpStatus.BAD_REQUEST,"The client was not registered"),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"The client not has categories"),
    CATEGORY_WAS_NOT_REGISTERED(HttpStatus.BAD_REQUEST,"The category was not registered"),
    FIXED_PAYMENT_NO_REGISTER(HttpStatus.BAD_REQUEST,"The category was not registered");

    private final HttpStatus httpStatus;
    private final String message;

    StatusCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}