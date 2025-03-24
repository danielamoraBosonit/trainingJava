package com.training.content.employee_report.infrastructure.controller.dto;

import com.training.content.employee_report.domain.entity.DayDetail;
import com.training.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReportOutputDto {

    private Integer employeeId;
    private Integer monthWorkingDays;
    private Integer theoreticalWorkingHours;
    private Integer month;
    private Integer year;
    private Integer attendanceDays;
    private Integer missingDays;
    private Integer daysWithErrors;
    private Duration totalWorkedTime;
    private List<DayDetail> monthDetail;
    private List<TimeClockOutputDto> timeClockList;

}
