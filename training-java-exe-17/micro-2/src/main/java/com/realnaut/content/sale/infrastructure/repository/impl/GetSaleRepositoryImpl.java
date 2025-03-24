package com.realnaut.content.sale.infrastructure.repository.impl;

import com.realnaut.content.sale.application.mapper.SaleMapper;
import com.realnaut.content.sale.domain.entity.Sale;
import com.realnaut.content.sale.domain.repository.GetSaleRepository;
import com.realnaut.content.sale.infrastructure.repository.mongo.SaleRepositoryMongoDB;
import com.realnaut.content.sale.infrastructure.repository.mongo.entity.SaleMongoDB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetSaleRepositoryImpl implements GetSaleRepository {

    private final SaleRepositoryMongoDB repoMongoDb;

    private final SaleMapper mapper;


    @Override
    public List<Sale> getAllByProduct(Integer productId) {

        List<SaleMongoDB> saleMongoDBList;

        if (productId != null){
            saleMongoDBList = repoMongoDb.findByProductId(productId);

        } else {
            saleMongoDBList = repoMongoDb.findAll();
        }

        return saleMongoDBList.stream().map(mapper::mongoDbToDomain).collect(Collectors.toList());

    }
}
