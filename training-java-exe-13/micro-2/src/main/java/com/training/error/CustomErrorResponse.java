package com.training.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class CustomErrorResponse {

    private String message;
    private String errorCode;
    private HttpStatus httpStatus;
}
