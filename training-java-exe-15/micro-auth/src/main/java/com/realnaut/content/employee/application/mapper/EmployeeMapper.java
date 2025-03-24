package com.realnaut.content.employee.application.mapper;

import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee jpaToDomain(EmployeeJpa employeeJpa);


}
