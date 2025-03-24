package com.realnaut.content.time_clock.domain.repository;

import com.realnaut.content.time_clock.domain.entity.TimeClock;

import java.time.LocalDateTime;
import java.util.List;

public interface GetTimeClockRepository {

    List<TimeClock> getAllByEmployeeId(Integer employeeId);

    List<TimeClock> getAllByEmployeeIdAndTimeBetween(Integer employeeId, LocalDateTime from, LocalDateTime now);

}
