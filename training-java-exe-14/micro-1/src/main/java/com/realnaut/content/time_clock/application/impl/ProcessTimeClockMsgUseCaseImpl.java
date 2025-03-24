package com.realnaut.content.time_clock.application.impl;

import com.realnaut.content.employee.application.UpdateEmployeeUseCase;
import com.realnaut.content.time_clock.application.ProcessTimeClockMsgUseCase;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.domain.enums.TimeClockType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class ProcessTimeClockMsgUseCaseImpl implements ProcessTimeClockMsgUseCase {

    private final UpdateEmployeeUseCase updateEmployeeUseCase;


    @Override
    public void processTimeClock(TimeClock timeClock) {

        if (timeClock.getType().equals(TimeClockType.ENTER.name())){
            updateEmployeeUseCase.setStatus(timeClock.getEmail(), true, timeClock.getTime());

        } else if (timeClock.getType().equals(TimeClockType.EXIT.name())){
            updateEmployeeUseCase.setStatus(timeClock.getEmail(), false, timeClock.getTime());

        }

    }


}
