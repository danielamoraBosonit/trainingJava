package com.realnaut.content.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String description;
    private LocalDateTime creationDate;
    private Integer unitsBox;
    private String packaging;

}
