package com.realnaut.content.employee.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeOutputDto {

    private Integer id;

    private String name;

    private String surnames;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String department;

    private String category;

    private Boolean online;

    private LocalDateTime lastStatus;

}
