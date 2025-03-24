package com.realnaut.content.product_price.infrastructure.repository.impl;

import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.domain.repository.GetProductPriceRepository;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceFilters;
import com.realnaut.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.realnaut.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import com.realnaut.shared.criteria.CriteriaJpaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetProductPriceRepositoryImpl implements GetProductPriceRepository {

    private final ProductPriceRepositoryJpa repoJpa;

    private final ProductPriceMapper mapper;

    private final CriteriaJpaBuilder<ProductPriceJpa> criteriaJpaBuilder;


    @Override
    public ProductPrice getById(Long id) {

        ProductPriceJpa productPriceJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(productPriceJpa);
    }

    @Override
    public List<ProductPrice> getAll(ProductPriceFilters filters) {

        Specification<ProductPriceJpa> specifications = null;

        if (filters != null) {
            specifications = setSpecifications(filters);
        }

        List<ProductPriceJpa> productPriceJpaList = repoJpa.findAll(Specification.where(specifications));

        return productPriceJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }

    private Specification<ProductPriceJpa> setSpecifications(ProductPriceFilters filters){
        Specification<ProductPriceJpa> specifications = null;

        specifications = criteriaJpaBuilder.addSpec(filters.getId(), "id", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getBrandId(), "brandId", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getPriceList(), "priceList", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getProductId(), "productId", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getPriority(), "priority", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getPrice(), "price", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getCurrency(), "curr", specifications);

        return specifications;
    }

}
