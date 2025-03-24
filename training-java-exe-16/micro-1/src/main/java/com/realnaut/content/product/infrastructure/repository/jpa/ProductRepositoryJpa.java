package com.realnaut.content.product.infrastructure.repository.jpa;

import com.realnaut.content.product.infrastructure.repository.jpa.entity.ProductJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryJpa extends JpaRepository<ProductJpa, Long> {
    List<ProductJpa> findAllByPackagingAndUnitsBox(String packaging, Integer unitsBox);
}
