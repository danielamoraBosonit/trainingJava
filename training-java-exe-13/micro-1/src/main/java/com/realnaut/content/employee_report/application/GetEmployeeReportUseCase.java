package com.realnaut.content.employee_report.application;

import com.realnaut.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;

public interface GetEmployeeReportUseCase {

    EmployeeReportOutputVO getEmployeeReport(Integer employeeId, Integer month, Integer year);

}
