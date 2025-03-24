package com.training.content.employee.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String name;

    private String surnames;

    private LocalDate birthDate;

    private String department;

    private String category;

    private Boolean online;

    private LocalDateTime lastStatus;

}
