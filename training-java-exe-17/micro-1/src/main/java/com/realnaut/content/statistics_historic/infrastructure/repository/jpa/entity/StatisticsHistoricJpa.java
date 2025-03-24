package com.realnaut.content.statistics_historic.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "statistics_historic")
public class StatisticsHistoricJpa {

    @Id
    @SequenceGenerator(name = "statistics_historic_sequence", sequenceName = "statistics_historic_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statistics_historic_sequence")
    private Long id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "total_units")
    private Integer totalUnits;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "statistics_date")
    private LocalDateTime statisticsDate;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}
