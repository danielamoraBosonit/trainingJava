package com.realnaut.content.time_clock.application;

import com.realnaut.content.time_clock.domain.entity.TimeClock;

import java.time.LocalDateTime;
import java.util.List;

public interface GetTimeClockUseCase {

    List<TimeClock> getAllByEmail(String email);

    List<TimeClock> getAllByEmailAndTimeBetween(String email, LocalDateTime from, LocalDateTime now);
}
