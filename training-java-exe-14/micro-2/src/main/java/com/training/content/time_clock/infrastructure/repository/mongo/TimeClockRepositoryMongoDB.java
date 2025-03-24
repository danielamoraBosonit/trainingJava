package com.training.content.time_clock.infrastructure.repository.mongo;

import com.training.content.time_clock.infrastructure.repository.mongo.entity.TimeClockMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeClockRepositoryMongoDB extends MongoRepository <TimeClockMongoDB, String>{
    List<TimeClockMongoDB> findByEmail(String email);

    List<TimeClockMongoDB> findByEmailAndTimeBetween(String email, LocalDateTime from, LocalDateTime now);
}
