package com.realnaut.content.employee_report.application.mapper;

import com.realnaut.content.employee_report.domain.entity.EmployeeReport;
import com.realnaut.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeReportMapper {

    EmployeeReportOutputDto domainToOutputDto(EmployeeReport employeeReport);

}
