package com.training.content.product.infrastructure.repository.jpa.entity;

import com.training.content.statistics.infrastructure.repository.jpa.entity.StatisticsJpa;
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
@Table(name = "product")
public class ProductJpa {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;

    private String description;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "units_box")
    private Integer unitsBox;

    private String packaging;

    @OneToOne(mappedBy = "productId")
    private StatisticsJpa statistics;

}
