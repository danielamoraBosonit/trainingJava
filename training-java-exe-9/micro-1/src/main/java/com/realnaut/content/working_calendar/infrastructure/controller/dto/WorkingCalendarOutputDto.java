package com.realnaut.content.working_calendar.infrastructure.controller.dto;

import com.realnaut.content.employee.infrastructure.controller.dto.EmployeeOutputDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkingCalendarOutputDto {

    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private EmployeeOutputDto employeeId;
    private int cityId;
    private Integer interval;


}
