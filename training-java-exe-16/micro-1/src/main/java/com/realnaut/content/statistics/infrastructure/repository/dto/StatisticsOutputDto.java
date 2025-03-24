package com.realnaut.content.statistics.infrastructure.repository.dto;

import com.realnaut.content.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsOutputDto {

    private Long id;
    private Integer productId;
    private Integer totalUnits;
    private Double totalAmount;

}
