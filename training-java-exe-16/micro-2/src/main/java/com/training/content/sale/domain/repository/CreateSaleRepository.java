package com.training.content.sale.domain.repository;

import com.training.content.sale.domain.entity.Sale;


public interface CreateSaleRepository {
    Sale create(Sale sale);
}
