package com.training.content.employee_report.infrastructure.controller;

import com.training.content.employee_report.application.GetEmployeeReportUseCase;
import com.training.content.employee_report.application.mapper.EmployeeReportMapper;
import com.training.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
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

        log.info("Petición recibida para employee: {}", employeeId);
        return useCase.getEmployeeReport(employeeId, month, year);

    }

}
