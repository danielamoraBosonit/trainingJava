package com.realnaut.content.employee_report.application.impl;

import com.realnaut.content.employee.application.GetEmployeeUseCase;
import com.realnaut.content.employee.application.mapper.EmployeeMapper;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee_report.application.GetEmployeeReportUseCase;
import com.realnaut.content.employee_report.domain.entity.EmployeeReport;
import com.realnaut.content.employee_report.infrastructure.controller.dto.EmployeeReportOutputVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Service
public class GetEmployeeReportUseCaseImpl implements GetEmployeeReportUseCase {

    private static String HOST_MICRO2;

    private GetEmployeeUseCase getEmployeeUseCase;

    private EmployeeMapper employeeMapper;


    public GetEmployeeReportUseCaseImpl(@Value("${micro2.host}") String HOST_MICRO2,
                                        GetEmployeeUseCase getEmployeeUseCase,
                                        EmployeeMapper employeeMapper) {
        this.HOST_MICRO2 = HOST_MICRO2;
        this.getEmployeeUseCase = getEmployeeUseCase;
        this.employeeMapper = employeeMapper;
    }


    @Override
    public EmployeeReportOutputVO getEmployeeReport(Integer employeeId, Integer month, Integer year) {

        Employee employee = getEmployeeUseCase.getById(employeeId);
        EmployeeReport employeeReport = null;

        WebClient webClient = WebClient.create(HOST_MICRO2);

        try {
            employeeReport = webClient.get()
                    .uri("/api/employee-report/employee/"+ employeeId + "/month/" + month + "/year/" + year)
                    .retrieve()
                    .bodyToMono(EmployeeReport.class)
                    .block();

        } catch (Exception e){
            log.error(e.getMessage());
        }

        return EmployeeReportOutputVO.builder()
                .employee(employeeMapper.domainToOutputDto(employee))
                .employeeReport(employeeReport)
                .build();
    }

}
