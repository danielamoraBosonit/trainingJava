package com.training;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;

import java.time.LocalDateTime;

public class TestData {


    public static WorkingCalendar getWorkingCalendar0(){
        return WorkingCalendar.builder()
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(3)
                .employeeId(3)
                .cityId(1)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar1(){
        return WorkingCalendar.builder()
                .id(1)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 6, 30, 23, 59, 59))
                .priority(10)
                .employeeId(1)
                .cityId(1)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar2(){
        return WorkingCalendar.builder()
                .id(2)
                .startDate(LocalDateTime.of(2023, 7, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(1)
                .cityId(2)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar3(){
        return WorkingCalendar.builder()
                .id(3)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(2)
                .cityId(3)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar4(){
        return WorkingCalendar.builder()
                .id(4)
                .startDate(LocalDateTime.of(2023, 8, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 8, 31, 23, 59, 59))
                .priority(8)
                .employeeId(2)
                .cityId(4)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa1(){
        return WorkingCalendarJpa.builder()
                .id(1)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 6, 30, 23, 59, 59))
                .priority(10)
                .employeeId(1)
                .cityId(1)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa2(){
        return WorkingCalendarJpa.builder()
                .id(2)
                .startDate(LocalDateTime.of(2023, 7, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(1)
                .cityId(2)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa3(){
        return WorkingCalendarJpa.builder()
                .id(3)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(2)
                .cityId(3)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa4(){
        return WorkingCalendarJpa.builder()
                .id(4)
                .startDate(LocalDateTime.of(2023, 8, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 8, 31, 23, 59, 59))
                .priority(8)
                .employeeId(2)
                .cityId(4)
                .build();
    }


}
