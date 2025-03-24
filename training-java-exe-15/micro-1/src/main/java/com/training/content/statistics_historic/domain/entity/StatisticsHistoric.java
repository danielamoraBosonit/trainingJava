package com.training.content.statistics_historic.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsHistoric {

    private Long id;
    private Integer productId;
    private Integer totalUnits;
    private Double totalAmount;
    private LocalDateTime statisticsDate;

}
