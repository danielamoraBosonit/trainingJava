package com.training.content.time_clock.application;

import com.training.content.time_clock.domain.entity.TimeClock;

import java.time.LocalDateTime;
import java.util.List;

public interface GetTimeClockUseCase {

    List<TimeClock> getAllByEmployeeId(Integer employeeId);

    List<TimeClock> getAllByEmployeeIdAndTimeBetween(Integer employeeId, LocalDateTime from, LocalDateTime now);
}
