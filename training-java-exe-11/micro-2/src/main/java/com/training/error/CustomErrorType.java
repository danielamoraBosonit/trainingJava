package com.training.error;


public enum CustomErrorType {

    TIME_CLOCK_ERROR("Error tipo de fichaje incorrecto", "E0001");

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
