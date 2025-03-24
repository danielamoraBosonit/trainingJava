package com.training.error;

import lombok.Data;

@Data
public class CustomException extends Exception {

    private String code;

    public CustomException(CustomErrorType customErrorType) {
        super(customErrorType.getMessage());
        this.code = customErrorType.getErrorCode();
    }

}
