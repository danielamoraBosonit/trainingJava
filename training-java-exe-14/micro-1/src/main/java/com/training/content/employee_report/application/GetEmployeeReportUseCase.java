package com.training.content.employee_report.application;

import com.training.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;

public interface GetEmployeeReportUseCase {

    EmployeeReportOutputVO getEmployeeReport(String email, Integer month, Integer year);

}
