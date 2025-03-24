package com.realnaut.content.employee.domain.repository;

import com.realnaut.content.employee.domain.entity.Employee;

import java.util.Optional;

public interface GetEmployeeRepository {

    Optional<Employee> findByEmail(String email);
}
