package com.training.content.employee_report.application;

import com.training.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;

public interface GetEmployeeReportUseCase {

    EmployeeReportOutputVO getEmployeeReport(Integer employeeId, Integer month, Integer year);

}
