package com.training.content.employee.infrastructure.repository.impl;

import com.training.content.employee.application.mapper.EmployeeMapper;
import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.domain.repository.UpdateEmployeeRepository;
import com.training.content.employee.infrastructure.repository.jpa.EmployeeRepositoryJpa;
import com.training.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class UpdateEmployeeRepositoryImpl implements UpdateEmployeeRepository {

    private final EmployeeRepositoryJpa repoJpa;

    private final EmployeeMapper mapper;

    @Override
    @Transactional
    public Employee setStatus(Integer id, Boolean status, LocalDateTime time) {
        EmployeeJpa employeeJpa = repoJpa.getReferenceById(id);

        employeeJpa.setOnline(status);

        employeeJpa.setLastStatus(time);

        return mapper.jpaToDomain(employeeJpa);
    }

}
