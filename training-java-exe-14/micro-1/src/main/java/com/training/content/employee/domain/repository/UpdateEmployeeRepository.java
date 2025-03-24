package com.training.content.employee.domain.repository;

import com.training.content.employee.domain.entity.Employee;

import java.time.LocalDateTime;


public interface UpdateEmployeeRepository {

    Employee setStatus(String email, Boolean status, LocalDateTime time);

}
