package com.training.content.statistics.infrastructure.repository.dto;

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
