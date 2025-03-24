package com.realnaut.content.working_calendar.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkingCalendarFilters {

    private Integer id;
    private Integer employeeId;
    private Integer priority;
    private Integer cityId;

}
