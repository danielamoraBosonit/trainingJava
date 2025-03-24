package com.training.content.statistics.domain.entity;

import com.training.content.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    private Long id;
    private Product productId;
    private Integer totalUnits;
    private Double totalAmount;

}
