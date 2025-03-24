package com.training.content.product_price.infrastructure.repository.impl;

import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.GetProductPriceRepository;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceFilters;
import com.training.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import com.training.shared.criteria.CriteriaJpaBuilder;
import lombok.AllArgsConstructor;
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
