package com.training.content.employee.application;

import com.training.content.employee.domain.entity.Employee;

import java.time.LocalDateTime;


public interface UpdateEmployeeUseCase {

    Employee setStatus(String email, Boolean status, LocalDateTime time);

}
