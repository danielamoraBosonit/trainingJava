package com.training.content.sale.domain.repository;

import com.training.content.sale.domain.entity.Sale;

import java.util.List;

public interface GetSaleRepository {

    List<Sale> getAllByProduct(Integer productId);

}
