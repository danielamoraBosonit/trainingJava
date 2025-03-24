package com.training.content.auth.application.impl;

import com.training.content.auth.application.JwtService;
import com.training.content.auth.application.LoginUseCase;
import com.training.content.auth.infrastructure.dto.LoginRequest;
import com.training.content.auth.infrastructure.dto.LoginResponse;
import com.training.content.employee.domain.repository.GetEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final GetEmployeeRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    @Override
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        var jwt = jwtService.generateToken(user);

        return LoginResponse.builder()
                .role(user.getRole().toUpperCase())
                .email(user.getEmail())
                .success(true)
                .token(jwt).build();
    }
}
