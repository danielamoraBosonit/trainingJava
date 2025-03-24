package com.training.content.statistics.infrastructure.repository.jpa.entity;

import com.training.content.product.infrastructure.repository.jpa.entity.ProductJpa;
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
@Table(name = "statistics")
public class StatisticsJpa {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductJpa productId;

    @Column(name = "total_units")
    private Integer totalUnits;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;


}