package com.training.content.product_price.infrastructure.repository.jpa;

import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepositoryJpa extends JpaRepository<ProductPriceJpa, Long>, JpaSpecificationExecutor<ProductPriceJpa> {
}
