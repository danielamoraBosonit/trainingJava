package com.training.content.employee.application.impl;

import com.training.content.employee.application.UpdateEmployeeUseCase;
import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.domain.repository.UpdateEmployeeRepository;
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
    public Employee setStatus(Integer id, Boolean status, LocalDateTime time) {
        return repo.setStatus(id, status, time);
    }
}
