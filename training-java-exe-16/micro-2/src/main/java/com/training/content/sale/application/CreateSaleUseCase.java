package com.training.content.sale.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.content.sale.domain.entity.Sale;

import java.util.concurrent.ExecutionException;


public interface CreateSaleUseCase {

    Sale create(Sale sale) throws ExecutionException, JsonProcessingException, InterruptedException;

}
