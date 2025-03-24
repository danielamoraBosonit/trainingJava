package com.training.content.product_price.infrastructure.repository.jpa.entity;

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
@Table(name = "product_price")
public class ProductPriceJpa {

    @Id
    @SequenceGenerator(name = "product_price_sequence", sequenceName = "product_price_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_price_sequence")
    private Long id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductJpa productId;

    private Integer priority;

    private Double price;

    private String curr;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}
