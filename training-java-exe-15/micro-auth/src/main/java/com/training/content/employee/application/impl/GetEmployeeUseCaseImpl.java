package com.training.content.employee.application.impl;

import com.training.content.employee.application.GetEmployeeUseCase;
import com.training.content.employee.domain.repository.GetEmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class GetEmployeeUseCaseImpl implements GetEmployeeUseCase {


    private final GetEmployeeRepository repo;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return repo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
