package com.training.content.auth.application;

import com.training.content.auth.infrastructure.dto.LoginRequest;
import com.training.content.auth.infrastructure.dto.LoginResponse;

public interface LoginUseCase {

    LoginResponse login(LoginRequest request);
}
