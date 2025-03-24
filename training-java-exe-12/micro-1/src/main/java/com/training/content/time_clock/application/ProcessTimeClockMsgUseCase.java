package com.training.content.time_clock.application;

import com.training.content.time_clock.domain.entity.TimeClock;


public interface ProcessTimeClockMsgUseCase {

    void processTimeClock(TimeClock timeClock);

}
