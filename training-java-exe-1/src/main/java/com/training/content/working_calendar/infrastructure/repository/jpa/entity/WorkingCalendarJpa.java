package com.training.content.working_calendar.infrastructure.repository.jpa.entity;

import com.training.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "working_calendar")
public class WorkingCalendarJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private int priority;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private EmployeeJpa employeeId;

    @Column(name = "city_id")
    private int cityId;

}
