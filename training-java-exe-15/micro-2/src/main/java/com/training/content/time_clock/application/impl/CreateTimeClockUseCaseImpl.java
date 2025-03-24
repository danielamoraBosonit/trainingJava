package com.training.content.time_clock.application.impl;

import com.training.content.time_clock.application.CreateTimeClockUseCase;
import com.training.content.time_clock.domain.entity.TimeClock;
import com.training.content.time_clock.domain.enums.TimeClockType;
import com.training.content.time_clock.domain.repository.CreateTimeClockRepository;
import com.training.error.CustomErrorType;
import com.training.error.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@AllArgsConstructor
public class CreateTimeClockUseCaseImpl implements CreateTimeClockUseCase {

    private final CreateTimeClockRepository repo;

    private final GetTimeClockUseCaseImpl getRepo;

    @Override
    public TimeClock create(TimeClock timeClock) throws Exception {

        timeClock.setTime(LocalDateTime.now(ZoneId.of("CET")));
        timeClock.setType(TimeClockType.valueOf(timeClock.getType().toUpperCase()).name());

        if (!validateTimeClockType(timeClock)){
            log.error("Type of Time Clock error for employee {} type {} time {} ",
                    timeClock.getEmail(), timeClock.getType(), timeClock.getTime());
            throw new CustomException(CustomErrorType.TIME_CLOCK_ERROR);
        }

        return repo.create(timeClock);
    }

    private boolean validateTimeClockType(TimeClock timeClock) {

        List<TimeClock> timeClockList = getRepo.getAllByEmailAndTimeBetween(timeClock.getEmail(),
                                                 LocalDateTime.from(LocalDate.now(ZoneId.of("CET")).atStartOfDay()),
                                                 LocalDateTime.now(ZoneId.of("CET")));

        Optional<TimeClock> timeClockOptional = timeClockList.stream().max(Comparator.comparing(TimeClock::getTime));

        if (timeClock.getType().toUpperCase().equals(TimeClockType.ENTER.name())){

            return timeClockOptional.isEmpty() ||
                   timeClockOptional.get().getType().toUpperCase().equals(TimeClockType.EXIT.name());

        } else {

            return timeClockOptional.isPresent() &&
                   timeClockOptional.get().getType().toUpperCase().equals(TimeClockType.ENTER.name());
        }
    }
}
