package com.realnaut.config.mongo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.content.sale.infrastructure.repository.mongo.entity.SaleMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        mongoTemplate.dropCollection("sale");

        InputStream inputStream = getClass().getResourceAsStream("/data.json");
        List<SaleMongoDB> documents = objectMapper.readValue(inputStream, new TypeReference<List<SaleMongoDB>>() {
        });

        mongoTemplate.insertAll(documents);
    }
}

