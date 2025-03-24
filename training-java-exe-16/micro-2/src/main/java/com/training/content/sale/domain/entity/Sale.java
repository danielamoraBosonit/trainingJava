package com.training.content.sale.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    private String id;

    private Integer productId;

    private Integer units;

    private Double unitPrice;

    private LocalDate saleDate;

    private Integer customerId;

}
