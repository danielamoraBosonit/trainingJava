package com.training.content.time_clock.infrastructure.repository.impl;

import com.training.content.time_clock.application.mapper.TimeClockMapper;
import com.training.content.time_clock.domain.entity.TimeClock;
import com.training.content.time_clock.domain.repository.CreateTimeClockRepository;
import com.training.content.time_clock.infrastructure.repository.mongo.TimeClockRepositoryMongoDB;
import com.training.content.time_clock.infrastructure.repository.mongo.entity.TimeClockMongoDB;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Slf4j
@Service
public class CreateTimeClockRepositoryImpl implements CreateTimeClockRepository {

    private final TimeClockRepositoryMongoDB repoMongoDb;

    private final TimeClockMapper mapper;

    @Override
    public TimeClock create(TimeClock timeClock) {
        TimeClockMongoDB timeClockMongoDB = mapper.domainToMongoDB(timeClock);

        TimeClockMongoDB timeClockMongoDBCreated = repoMongoDb.insert(timeClockMongoDB);

        log.info("Create Time Clock for employee {} type {} time {} ",
                timeClock.getEmployeeId(), timeClock.getType(), timeClock.getTime());

        return mapper.mongoDbToDomain(timeClockMongoDBCreated);
    }
}
