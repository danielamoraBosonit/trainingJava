package com.realnaut.content.sale.infrastructure.repository.mongo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document(collection = "sale")
public class SaleMongoDB {

    @Id
    private String id;

    private Integer productId;

    private Integer units;

    private Double unitPrice;

    private LocalDate saleDate;

    private Integer customerId;

}
