package com.realnaut.content.employee.application.impl;

import com.realnaut.content.employee.application.UpdateEmployeeUseCase;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.domain.repository.UpdateEmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@AllArgsConstructor
@Service
public class UpdateEmployeeUseCaseImpl implements UpdateEmployeeUseCase {

    private final UpdateEmployeeRepository repo;

    @Override
    public Employee setStatus(String email, Boolean status, LocalDateTime time) {
        return repo.setStatus(email, status, time);
    }
}
