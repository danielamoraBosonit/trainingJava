package com.realnaut.content.employee.application;

import com.realnaut.content.employee.domain.entity.Employee;

import java.util.List;

public interface GetEmployeeUseCase {

    Employee getById(Integer id);

    List<Employee> getAll(String department, String category);

}
