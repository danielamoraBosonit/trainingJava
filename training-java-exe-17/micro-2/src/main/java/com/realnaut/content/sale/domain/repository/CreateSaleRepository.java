package com.realnaut.content.sale.domain.repository;

import com.realnaut.content.sale.domain.entity.Sale;


public interface CreateSaleRepository {
    Sale create(Sale sale);
}
