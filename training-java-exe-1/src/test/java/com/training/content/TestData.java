package com.training.content;

import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestData {


    public static WorkingCalendar getWorkingCalendar0(){
        return WorkingCalendar.builder()
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(3)
                .employeeId(getEmployee3())
                .cityId(1)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar1(){
        return WorkingCalendar.builder()
                .id(1)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 6, 30, 23, 59, 59))
                .priority(10)
                .employeeId(getEmployee1())
                .cityId(1)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar2(){
        return WorkingCalendar.builder()
                .id(2)
                .startDate(LocalDateTime.of(2023, 7, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(getEmployee2())
                .cityId(2)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar3(){
        return WorkingCalendar.builder()
                .id(3)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(getEmployee3())
                .cityId(3)
                .build();
    }


    public static WorkingCalendar getWorkingCalendar4(){
        return WorkingCalendar.builder()
                .id(4)
                .startDate(LocalDateTime.of(2023, 8, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 8, 31, 23, 59, 59))
                .priority(8)
                .employeeId(getEmployee4())
                .cityId(4)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa1(){
        return WorkingCalendarJpa.builder()
                .id(1)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 6, 30, 23, 59, 59))
                .priority(10)
                .employeeId(getEmployeeJpa1())
                .cityId(1)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa2(){
        return WorkingCalendarJpa.builder()
                .id(2)
                .startDate(LocalDateTime.of(2023, 7, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(getEmployeeJpa2())
                .cityId(2)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa3(){
        return WorkingCalendarJpa.builder()
                .id(3)
                .startDate(LocalDateTime.of(2023, 1, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priority(10)
                .employeeId(getEmployeeJpa3())
                .cityId(3)
                .build();
    }


    public static WorkingCalendarJpa getWorkingCalendarJpa4(){
        return WorkingCalendarJpa.builder()
                .id(4)
                .startDate(LocalDateTime.of(2023, 8, 1, 0, 0, 0))
                .endDate(LocalDateTime.of(2023, 8, 31, 23, 59, 59))
                .priority(8)
                .employeeId(getEmployeeJpa4())
                .cityId(4)
                .build();
    }


    public static Employee getEmployee1(){
        return Employee.builder()
                .id(1)
                .name("Carlos")
                .surnames("Jimenez Garcia")
                .birthDate(LocalDate.of(1984,9,18))
                .department("Desarrollo")
                .category("Senior")
                .build();
    }


    public static Employee getEmployee2(){
        return Employee.builder()
                .id(2)
                .name("Ana")
                .surnames("Ruiz Lopez")
                .birthDate(LocalDate.of(1991,1,2))
                .department("QA")
                .category("Midior")
                .build();
    }

    public static Employee getEmployee3(){
        return Employee.builder()
                .id(3)
                .name("Pedro")
                .surnames("Fernandez Gomez")
                .birthDate(LocalDate.of(1979,4,7))
                .department("Desarrollo")
                .category("Senior")
                .build();
    }

    public static Employee getEmployee4(){
        return Employee.builder()
                .id(4)
                .name("Laura")
                .surnames("Gonzalo Martin")
                .birthDate(LocalDate.of(1999,5,15))
                .department("UX/UI")
                .category("Senior")
                .build();
    }

    public static EmployeeJpa getEmployeeJpa1(){
        return EmployeeJpa.builder()
                .id(1)
                .name("Carlos")
                .surnames("Jimenez Garcia")
                .birthDate(LocalDate.of(1984,9,18))
                .department("Desarrollo")
                .category("Senior")
                .build();
    }


    public static EmployeeJpa getEmployeeJpa2(){
        return EmployeeJpa.builder()
                .id(2)
                .name("Ana")
                .surnames("Ruiz Lopez")
                .birthDate(LocalDate.of(1991,1,2))
                .department("QA")
                .category("Midior")
                .build();
    }

    public static EmployeeJpa getEmployeeJpa3(){
        return EmployeeJpa.builder()
                .id(3)
                .name("Pedro")
                .surnames("Fernandez Gomez")
                .birthDate(LocalDate.of(1979,4,7))
                .department("Desarrollo")
                .category("Senior")
                .build();
    }

    public static EmployeeJpa getEmployeeJpa4(){
        return EmployeeJpa.builder()
                .id(4)
                .name("Laura")
                .surnames("Gonzalo Martin")
                .birthDate(LocalDate.of(1999,5,15))
                .department("UX/UI")
                .category("Senior")
                .build();
    }

}
