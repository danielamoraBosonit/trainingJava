package com.training.content.employee_report.application;

import com.training.content.employee_report.domain.entity.EmployeeReport;


public interface GetEmployeeReportUseCase {

    EmployeeReport getEmployeeReport(String email, Integer month, Integer year);

}
