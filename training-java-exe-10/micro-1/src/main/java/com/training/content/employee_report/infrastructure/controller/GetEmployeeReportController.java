package com.training.content.employee_report.infrastructure.controller;

import com.training.content.employee_report.application.GetEmployeeReportUseCase;
import com.training.content.employee_report.application.mapper.EmployeeReportMapper;
import com.training.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employee-report")
public class GetEmployeeReportController {

    private final GetEmployeeReportUseCase useCase;

    private final EmployeeReportMapper mapper;


    @GetMapping("/employee/{employeeId}/month/{month}/year/{year}")
    public EmployeeReportOutputVO getById(@PathVariable Integer employeeId,
                                          @PathVariable Integer month,
                                          @PathVariable Integer year){

        return useCase.getEmployeeReport(employeeId, month, year);

    }

}
