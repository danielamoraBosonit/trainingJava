package com.realnaut.content.product_price.infrastructure.controller.dto;

import com.realnaut.content.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceFilters {

    private Long id;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Product productId;
    private Integer priority;
    private Double price;
    private String currency;

}
