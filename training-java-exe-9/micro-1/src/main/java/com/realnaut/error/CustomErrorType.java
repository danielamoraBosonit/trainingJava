package com.realnaut.error;


public enum CustomErrorType {

    RESOURCE_NOT_FOUND("Recurso no encontrado", "E0001");

    private final String message;
    private final String errorCode;

    CustomErrorType(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
