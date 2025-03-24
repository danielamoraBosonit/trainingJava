package com.training.content.employee.application.mapper;

import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.infrastructure.controller.dto.EmployeeOutputDto;
import com.training.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee jpaToDomain(EmployeeJpa employeeJpa);

    EmployeeOutputDto domainToOutputDto(Employee employee);


}
