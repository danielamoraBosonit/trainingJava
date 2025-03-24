package com.training.content.employee_report.application.mapper;

import com.training.content.employee_report.domain.entity.EmployeeReport;
import com.training.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeReportMapper {

    EmployeeReportOutputVO domainToOutputDto(EmployeeReport employeeReport);


}
