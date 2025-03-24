package com.realnaut.content.sale.domain.repository;

import com.realnaut.content.sale.domain.entity.Sale;

import java.util.List;

public interface GetSaleRepository {

    List<Sale> getAllByProduct(Integer productId);

}
