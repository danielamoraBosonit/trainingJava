package com.realnaut.content.time_clock.application;

import com.realnaut.content.time_clock.domain.entity.TimeClock;


public interface ProcessTimeClockMsgUseCase {

    void processTimeClock(TimeClock timeClock);

}
