package com.training.content.employee_report.infrastructure.controller.dto;

import com.training.content.employee.infrastructure.controller.dto.EmployeeOutputDto;
import com.training.content.employee_report.domain.entity.EmployeeReport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReportOutputVO {

    private EmployeeOutputDto employee;
    private EmployeeReport employeeReport;

}
