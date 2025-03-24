package com.realnaut.content.employee.infrastructure.repository.impl;

import com.realnaut.content.employee.application.mapper.EmployeeMapper;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.domain.repository.GetEmployeeRepository;
import com.realnaut.content.employee.infrastructure.repository.jpa.EmployeeRepositoryJpa;
import com.realnaut.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class GetEmployeeRepositoryImpl implements GetEmployeeRepository {

    private final EmployeeRepositoryJpa repoJpa;

    private final EmployeeMapper mapper;


    @Override
    public Optional<Employee> findByEmail(String email) {
        Optional<EmployeeJpa> employeeJpaOptional = repoJpa.getByEmail(email);

        if (employeeJpaOptional.isPresent()){
            return Optional.of(mapper.jpaToDomain(employeeJpaOptional.get()));
        }

        return Optional.empty();
    }

}
