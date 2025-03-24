package com.training.content.sale.infrastructure.repository.mongo;

import com.training.content.sale.infrastructure.repository.mongo.entity.SaleMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleRepositoryMongoDB extends MongoRepository <SaleMongoDB, String>{
    List<SaleMongoDB> findByProductId(Integer productId);
}
