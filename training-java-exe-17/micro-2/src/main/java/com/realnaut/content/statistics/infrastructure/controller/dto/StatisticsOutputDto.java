package com.realnaut.content.statistics.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsOutputDto {

    private Integer productId;

    private Integer totalUnits;

    private Double totalAmount;

    private Double averagePrice;

}
