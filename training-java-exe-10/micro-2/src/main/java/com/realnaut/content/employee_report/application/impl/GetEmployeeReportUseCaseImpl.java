package com.realnaut.content.employee_report.application.impl;

import com.realnaut.content.employee_report.application.GetEmployeeReportUseCase;
import com.realnaut.content.employee_report.domain.entity.DayDetail;
import com.realnaut.content.employee_report.domain.entity.EmployeeReport;
import com.realnaut.content.time_clock.application.GetTimeClockUseCase;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.domain.enums.TimeClockType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetEmployeeReportUseCaseImpl implements GetEmployeeReportUseCase {

    public static final List<DayOfWeek> DAYS_OF_WEEK = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

    private final GetTimeClockUseCase getTimeClockUseCase;

    @Override
    public EmployeeReport getEmployeeReport(Integer employeeId, Integer month, Integer year) {

        YearMonth yearMonth = YearMonth.of(year, month);
        int lastDayOfMonth = yearMonth.lengthOfMonth();

        LocalDateTime from = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(year, month, lastDayOfMonth, 23, 59, 59);

        List<TimeClock> timeClockList = getTimeClockUseCase
                .getAllByEmployeeIdAndTimeBetween(employeeId, from, to);

        return buildEmployeeReport(employeeId, timeClockList, yearMonth);
    }

    private EmployeeReport buildEmployeeReport(Integer employeeId, List<TimeClock> timeClockList, YearMonth yearMonth) {

        int monthWorkingDays = 0, attendanceDays = 0, daysWithErrors = 0;

        List<DayDetail> monthDetail = new ArrayList<>();

        Duration totalWorkedTime = Duration.ZERO;

        LocalDate currentDate = yearMonth.atDay(1);
        while (!currentDate.isAfter(yearMonth.atEndOfMonth())) {

            LocalDateTime startOfDay = LocalDateTime.of(currentDate, LocalTime.of(0,0,0));
            LocalDateTime endOfDay = LocalDateTime.of(currentDate, LocalTime.of(23,59,59));

            List<TimeClock> timeClockDayList = timeClockList.stream()
                    .filter(x -> x.getTime().isAfter(startOfDay) && x.getTime().isBefore(endOfDay)).toList();

            if (!timeClockDayList.isEmpty()) {
                attendanceDays++;
                Duration dayWorkedTime = calculateDayTime(timeClockDayList);

                monthDetail.add(DayDetail.builder()
                        .date(currentDate)
                        .workTime(dayWorkedTime != null ? dayWorkedTime : Duration.ZERO)
                        .build());

                totalWorkedTime = totalWorkedTime.plus(dayWorkedTime != null ? dayWorkedTime : Duration.ZERO);
                daysWithErrors += (dayWorkedTime == null ? 1 : 0);

            } else {
                monthDetail.add(DayDetail.builder()
                        .date(currentDate)
                        .workTime(Duration.ZERO)
                        .build());
            }

            if (DAYS_OF_WEEK.contains(currentDate.getDayOfWeek())){
                monthWorkingDays++;
            }

            currentDate = currentDate.plusDays(1);
        }

        return EmployeeReport.builder()
                .employeeId(employeeId)
                .timeClockList(timeClockList)
                .monthWorkingDays(monthWorkingDays)
                .month(yearMonth.getMonthValue())
                .year(yearMonth.getYear())
                .attendanceDays(attendanceDays)
                .missingDays(monthWorkingDays - attendanceDays)
                .daysWithErrors(daysWithErrors)
                .totalWorkedTime(totalWorkedTime)
                .theoreticalWorkingHours(monthWorkingDays*8)
                .monthDetail(monthDetail)
                .build();
    }


    private Duration calculateDayTime(List<TimeClock> timeClockDayList) {

        timeClockDayList = timeClockDayList.stream().sorted(Comparator.comparing(TimeClock::getTime))
                .collect(Collectors.toList());

        LocalDateTime startTime = null;
        Duration totalWorkTime = Duration.ZERO;

        for (int i = 0; i < timeClockDayList.size(); i++){

            if (i % 2 == 0){
                if (!timeClockDayList.get(i).getType().equals(TimeClockType.ENTER.name())) return null;
                startTime = timeClockDayList.get(i).getTime();

            } else {
                if (!timeClockDayList.get(i).getType().equals(TimeClockType.EXIT.name()) ||
                        startTime == null) return null;
                Duration workTime = Duration.between(startTime, timeClockDayList.get(i).getTime());
                totalWorkTime = totalWorkTime.plus(workTime);
                startTime = null;
            }
        }
        return totalWorkTime;
    }


}
