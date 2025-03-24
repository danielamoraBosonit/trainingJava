package com.training.content.employee_report.application;

import com.training.content.employee_report.domain.entity.EmployeeReport;


public interface GetEmployeeReportUseCase {

    EmployeeReport getEmployeeReport(Integer employeeId, Integer month, Integer year);

}
