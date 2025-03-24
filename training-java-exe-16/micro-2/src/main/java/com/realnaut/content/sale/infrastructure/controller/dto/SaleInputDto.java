package com.realnaut.content.sale.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaleInputDto {

    private Integer productId;

    private Integer units;

    private Double unitPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleDate;

    private Integer customerId;
}
