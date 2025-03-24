package com.realnaut.content.working_calendar.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class WorkingCalendar {

    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private int employeeId;
    private int cityId;

}
