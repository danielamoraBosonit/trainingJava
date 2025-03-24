package com.realnaut.content.employee.domain.repository;

import com.realnaut.content.employee.domain.entity.Employee;

import java.util.List;

public interface GetEmployeeRepository {
    Employee getById(Integer id);

    List<Employee> getAll(String department, String category);

    List<Employee> getOnlineState(boolean state);

    Employee getByEmail(String email);
}
