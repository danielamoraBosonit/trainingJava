package com.realnaut.content.time_clock.infrastructure.repository.impl;

import com.realnaut.content.time_clock.application.mapper.TimeClockMapper;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.domain.repository.GetTimeClockRepository;
import com.realnaut.content.time_clock.infrastructure.repository.mongo.TimeClockRepositoryMongoDB;
import com.realnaut.content.time_clock.infrastructure.repository.mongo.entity.TimeClockMongoDB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetTimeClockRepositoryImpl implements GetTimeClockRepository {

    private final TimeClockRepositoryMongoDB repoMongoDb;

    private final TimeClockMapper mapper;

    @Override
    public List<TimeClock> getAllByEmployeeId(Integer employeeId) {

        List<TimeClockMongoDB> timeClockMongoDBList;

        if (employeeId != null){
            timeClockMongoDBList = repoMongoDb.findByEmployeeId(employeeId);

        } else {
            timeClockMongoDBList = repoMongoDb.findAll();
        }

        return timeClockMongoDBList.stream().map(mapper::mongoDbToDomain).collect(Collectors.toList());

    }

    @Override
    public List<TimeClock> getAllByEmployeeIdAndTimeBetween(Integer employeeId, LocalDateTime from, LocalDateTime now) {

        List<TimeClockMongoDB> timeClockList = repoMongoDb.findByEmployeeIdAndTimeBetween(employeeId, from, now);

        return timeClockList.stream().map(mapper::mongoDbToDomain).collect(Collectors.toList());

    }
}
