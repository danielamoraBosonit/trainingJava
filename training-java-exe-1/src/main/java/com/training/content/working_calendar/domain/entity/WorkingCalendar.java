package com.training.content.working_calendar.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkingCalendar {

    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private int employeeId;
    private int cityId;

}
