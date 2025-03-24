package com.training.content.sale.infrastructure.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.content.sale.application.CreateSaleUseCase;
import com.training.content.sale.application.mapper.SaleMapper;
import com.training.content.sale.domain.entity.Sale;
import com.training.content.sale.infrastructure.controller.dto.SaleInputDto;
import com.training.content.sale.infrastructure.controller.dto.SaleOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class CreateSaleController {

    private final CreateSaleUseCase useCase;

    private final SaleMapper mapper;


    @PostMapping("/")
    public SaleOutputDto create(@RequestBody SaleInputDto inputDto) throws ExecutionException, JsonProcessingException, InterruptedException {

        Sale sale = mapper.inputDtoToDomain(inputDto);

        Sale saleReturned = useCase.create(sale);

        return mapper.domainToOutputDto(saleReturned);
    }

}
