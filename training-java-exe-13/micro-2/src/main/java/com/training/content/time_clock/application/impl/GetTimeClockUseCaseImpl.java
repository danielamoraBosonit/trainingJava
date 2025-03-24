package com.training.content.time_clock.application.impl;

import com.training.content.time_clock.application.GetTimeClockUseCase;
import com.training.content.time_clock.domain.entity.TimeClock;
import com.training.content.time_clock.domain.repository.GetTimeClockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class GetTimeClockUseCaseImpl implements GetTimeClockUseCase {

    private final GetTimeClockRepository repo;

    @Override
    public List<TimeClock> getAllByEmployeeId(Integer employeeId) {

        return repo.getAllByEmployeeId(employeeId);

    }

    @Override
    public List<TimeClock> getAllByEmployeeIdAndTimeBetween(Integer employeeId, LocalDateTime from, LocalDateTime now) {

        return repo.getAllByEmployeeIdAndTimeBetween(employeeId, from, now);

    }

}
