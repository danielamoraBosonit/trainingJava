package com.training.content.working_calendar.infrastructure.repository.jpa.entity;

import com.training.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "working_calendar")
public class WorkingCalendarJpa {

    @Id
    @SequenceGenerator(name = "working_calendar_sequence", sequenceName = "working_calendar_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "working_calendar_sequence")
    private Integer id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private int priority;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeJpa employeeId;

    @Column(name = "city_id")
    private int cityId;

}
