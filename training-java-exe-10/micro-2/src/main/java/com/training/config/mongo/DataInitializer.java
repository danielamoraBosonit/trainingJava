package com.training.config.mongo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.content.time_clock.infrastructure.repository.mongo.entity.TimeClockMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public DataInitializer(MongoTemplate mongoTemplate, ObjectMapper objectMapper) {
        this.mongoTemplate = mongoTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {

        mongoTemplate.dropCollection("time_clock");

        InputStream inputStream = getClass().getResourceAsStream("/data.json");
        List<TimeClockMongoDB> documents = objectMapper.readValue(inputStream, new TypeReference<List<TimeClockMongoDB>>() {
        });

        mongoTemplate.insertAll(documents);
    }
}

