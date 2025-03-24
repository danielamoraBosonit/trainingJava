package com.realnaut.content.auth.infrastructure.controller;

import com.realnaut.content.auth.application.LoginUseCase;
import com.realnaut.content.auth.infrastructure.dto.LoginRequest;
import com.realnaut.content.auth.infrastructure.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginUseCase.login(request));
    }
}
