package com.realnaut.content.employee.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employee")
public class EmployeeJpa {

    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Integer id;

    private String name;

    private String surnames;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String department;

    private String category;

    private Boolean online;

    @Column(name = "last_status")
    private LocalDateTime lastStatus;

    private String email;

    private String password;

    private String role;
}
