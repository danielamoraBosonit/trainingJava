package com.training.content.sale.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOutputDto {

    private String id;

    private Integer productId;

    private Integer units;

    private Double unitPrice;

    private LocalDate saleDate;

    private Integer customerId;

}
