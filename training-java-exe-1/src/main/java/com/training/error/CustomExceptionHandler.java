package com.training.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomException.class)
    public CustomErrorResponse handleCustomException(CustomException e) {
        return CustomErrorResponse.builder()
                .message(e.getMessage())
                .errorCode(e.getErrorCode())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }
}
