package com.realnaut.content.time_clock.infrastructure.repository.mongo;

import com.realnaut.content.time_clock.infrastructure.repository.mongo.entity.TimeClockMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeClockRepositoryMongoDB extends MongoRepository <TimeClockMongoDB, String>{
    List<TimeClockMongoDB> findByEmployeeId(Integer employeeId);

    List<TimeClockMongoDB> findByEmployeeIdAndTimeBetween(Integer employeeId, LocalDateTime from, LocalDateTime now);
}
