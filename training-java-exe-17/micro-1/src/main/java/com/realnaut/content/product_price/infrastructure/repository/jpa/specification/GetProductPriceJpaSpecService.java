package com.realnaut.content.product_price.infrastructure.repository.jpa.specification;

import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceFilters;
import com.realnaut.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import com.realnaut.shared.criteria.CriteriaJpaSpecification;
import com.realnaut.shared.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GetProductPriceJpaSpecService {


    public Specification<ProductPriceJpa> getSpecifications(ProductPriceFilters filters) {
        Specification<ProductPriceJpa> combinedSpec = null;

        if (filters != null) {
            combinedSpec = addSpecificationIfNotNull(filters.getId(), "id", combinedSpec, ":");
            combinedSpec = addSpecificationIfNotNull(filters.getBrandId(), "brandId", combinedSpec, ":");
            combinedSpec = addSpecificationIfNotNull(filters.getPriceList(), "priceList", combinedSpec, ":");
            combinedSpec = addSpecificationIfNotNull(filters.getProductId(), "productId", combinedSpec, ":");
            combinedSpec = addSpecificationIfNotNull(filters.getPriority(), "priority", combinedSpec, ":");
            combinedSpec = addSpecificationIfNotNull(filters.getPrice(), "price", combinedSpec, ":");
            combinedSpec = addSpecificationIfNotNull(filters.getCurrency(), "currency", combinedSpec, ":");
        }

        return combinedSpec;
    }

    private Specification<ProductPriceJpa> addSpecificationIfNotNull(Object value, String field,
                                                 Specification<ProductPriceJpa> specification, String operation) {
        if (value != null) {
            SearchCriteria searchCriteria = new SearchCriteria(field, value);
            return getSpecification(searchCriteria, specification);
        }
        return specification;
    }

    private Specification<ProductPriceJpa> getSpecification(SearchCriteria criteria, Specification<ProductPriceJpa> specification) {
        CriteriaJpaSpecification spec = new CriteriaJpaSpecification(criteria);
        specification = specification == null ? spec : specification.and(spec);
        return specification;
    }


}
