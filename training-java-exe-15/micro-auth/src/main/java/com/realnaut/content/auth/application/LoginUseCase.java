package com.realnaut.content.auth.application;

import com.realnaut.content.auth.infrastructure.dto.LoginRequest;
import com.realnaut.content.auth.infrastructure.dto.LoginResponse;

public interface LoginUseCase {

    LoginResponse login(LoginRequest request);
}
