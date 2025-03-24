package com.realnaut.content.working_calendar.infrastructure.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkingCalendarOutputDto {

    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private int employeeId;
    private int cityId;
    private Integer interval;


}
