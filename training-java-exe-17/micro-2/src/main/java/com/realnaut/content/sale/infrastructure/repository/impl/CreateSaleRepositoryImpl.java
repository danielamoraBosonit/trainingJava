package com.realnaut.content.sale.infrastructure.repository.impl;

import com.realnaut.content.sale.application.mapper.SaleMapper;
import com.realnaut.content.sale.domain.entity.Sale;
import com.realnaut.content.sale.domain.repository.CreateSaleRepository;
import com.realnaut.content.sale.infrastructure.repository.mongo.SaleRepositoryMongoDB;
import com.realnaut.content.sale.infrastructure.repository.mongo.entity.SaleMongoDB;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Slf4j
@Service
public class CreateSaleRepositoryImpl implements CreateSaleRepository {

    private final SaleRepositoryMongoDB repoMongoDb;

    private final SaleMapper mapper;


    @Override
    public Sale create(Sale sale) {
        SaleMongoDB saleMongoDB = mapper.domainToMongoDB(sale);

        SaleMongoDB saleMongoDBCreated = repoMongoDb.insert(saleMongoDB);

        log.info("Create sale for product {} ", sale.getProductId());

        return mapper.mongoDbToDomain(saleMongoDBCreated);
    }
}
