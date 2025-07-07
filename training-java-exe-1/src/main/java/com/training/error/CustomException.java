package com.training.error;

import lombok.Data;

@Data
public class CustomException extends Exception {

    private String errorCode;

    public CustomException(CustomErrorType errorType) {
        super(errorType.getMessage());
        errorCode = errorType.getErrorCode();
    }
}
