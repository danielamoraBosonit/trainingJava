package com.realnaut.content.employee.application;

import com.realnaut.content.employee.domain.entity.Employee;

import java.time.LocalDateTime;


public interface UpdateEmployeeUseCase {

    Employee setStatus(String email, Boolean status, LocalDateTime time);

}
