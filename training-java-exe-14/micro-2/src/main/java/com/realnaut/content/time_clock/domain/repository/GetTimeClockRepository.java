package com.realnaut.content.time_clock.domain.repository;

import com.realnaut.content.time_clock.domain.entity.TimeClock;

import java.time.LocalDateTime;
import java.util.List;

public interface GetTimeClockRepository {

    List<TimeClock> getAllByEmail(String email);

    List<TimeClock> getAllByEmailAndTimeBetween(String email, LocalDateTime from, LocalDateTime now);


}
