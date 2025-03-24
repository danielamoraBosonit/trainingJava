package com.training.content.time_clock.domain.repository;

import com.training.content.time_clock.domain.entity.TimeClock;


public interface CreateTimeClockRepository {

    TimeClock create(TimeClock timeClock);

}
