package com.training.content.employee_report.application.mapper;

import com.training.content.employee_report.domain.entity.EmployeeReport;
import com.training.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeReportMapper {

    EmployeeReportOutputDto domainToOutputDto(EmployeeReport employeeReport);

}
