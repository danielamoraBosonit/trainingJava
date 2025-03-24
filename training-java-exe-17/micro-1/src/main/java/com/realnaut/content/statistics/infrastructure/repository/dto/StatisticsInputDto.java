package com.realnaut.content.statistics.infrastructure.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsInputDto {

    private Long productId;
    private Integer totalUnits;
    private Double totalAmount;

}
