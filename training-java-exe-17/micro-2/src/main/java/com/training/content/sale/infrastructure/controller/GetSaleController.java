package com.training.content.sale.infrastructure.controller;

import com.training.content.sale.application.GetSaleUseCase;
import com.training.content.statistics.application.impl.StatisticsPublisherUserCaseImpl;
import com.training.content.sale.application.mapper.SaleMapper;
import com.training.content.sale.domain.entity.Sale;
import com.training.content.sale.infrastructure.controller.dto.SaleOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class GetSaleController {

    private final GetSaleUseCase useCase;

    private final SaleMapper mapper;

    private final StatisticsPublisherUserCaseImpl publisher;


    @GetMapping("/")
    public List<SaleOutputDto> getAll(@RequestParam (required = false) Integer productId){

        List<Sale> saleList = useCase.getAllByProduct(productId);

        return saleList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


}
