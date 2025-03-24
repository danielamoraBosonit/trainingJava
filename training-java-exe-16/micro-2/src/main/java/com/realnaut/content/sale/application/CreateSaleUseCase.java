package com.realnaut.content.sale.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.realnaut.content.sale.domain.entity.Sale;

import java.util.concurrent.ExecutionException;


public interface CreateSaleUseCase {

    Sale create(Sale sale) throws ExecutionException, JsonProcessingException, InterruptedException;

}
