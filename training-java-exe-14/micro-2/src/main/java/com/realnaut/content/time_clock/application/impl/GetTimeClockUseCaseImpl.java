package com.realnaut.content.time_clock.application.impl;

import com.realnaut.content.time_clock.application.GetTimeClockUseCase;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.domain.repository.GetTimeClockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class GetTimeClockUseCaseImpl implements GetTimeClockUseCase {

    private final GetTimeClockRepository repo;

    @Override
    public List<TimeClock> getAllByEmail(String email) {

        return repo.getAllByEmail(email);

    }

    @Override
    public List<TimeClock> getAllByEmailAndTimeBetween(String email, LocalDateTime from, LocalDateTime now) {

        return repo.getAllByEmailAndTimeBetween(email, from, now);

    }

}
