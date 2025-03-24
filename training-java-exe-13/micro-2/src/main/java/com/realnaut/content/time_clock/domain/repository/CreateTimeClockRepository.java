package com.realnaut.content.time_clock.domain.repository;

import com.realnaut.content.time_clock.domain.entity.TimeClock;


public interface CreateTimeClockRepository {

    TimeClock create(TimeClock timeClock);

}
