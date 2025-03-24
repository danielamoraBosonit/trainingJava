package com.realnaut.content.working_calendar.infrastructure.repository.jpa;

import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingCalendarRepositoryJpa extends JpaRepository<WorkingCalendarJpa, Integer> {
}
