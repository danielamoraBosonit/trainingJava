package com.realnaut.content.working_calendar.domain.entity;

import com.realnaut.content.employee.domain.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingCalendar {

    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private Employee employeeId;
    private int cityId;

}
