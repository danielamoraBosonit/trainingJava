package com.realnaut.content.product.application.impl;

import com.realnaut.content.product.application.GetProductUseCase;
import com.realnaut.content.product.application.mapper.ProductMapper;
import com.realnaut.content.product.domain.entity.Product;
import com.realnaut.content.product.domain.repository.GetProductRepository;
import com.realnaut.content.product.infrastructure.controller.dto.ProductOutputVO;
import com.realnaut.content.statistics.application.GetStatisticsUseCase;
import com.realnaut.content.statistics.domain.entity.Statistics;
import com.realnaut.content.statistics.infrastructure.repository.dto.StatisticsOutputDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class GetProductUseCaseImpl implements GetProductUseCase {

    private final GetProductRepository repo;

    private final ProductMapper mapper;

    private final GetStatisticsUseCase getStatisticsUseCase;


    @Override
    public Product getById(Long id){

        return repo.getById(id);
    }


    @Override
    public List<Product> getAll(String packaging, Integer unitsBox){

        return repo.getAll(packaging, unitsBox);
    }

    @Override
    public List<ProductOutputVO> getProductsStatistics(List<Integer> productIds) {

        Map<Long, Product> productMap = productIds.stream()
                .map(productId -> getById(productId.longValue()))
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        return productIds.parallelStream()
                .map(productId -> {
                    Product product = productMap.get(productId.longValue());
                    StatisticsOutputDto statistics = getStatisticsUseCase.getById(productId.longValue());

                    if (statistics != null) {
                        ProductOutputVO productOutputVO = mapper.domainToVO(product);
                        productOutputVO.setStatistics(statistics);
                        return productOutputVO;
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
