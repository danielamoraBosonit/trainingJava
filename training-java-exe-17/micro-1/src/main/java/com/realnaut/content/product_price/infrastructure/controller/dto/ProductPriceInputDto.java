package com.realnaut.content.product_price.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Input DTO for creating a product price")
public class ProductPriceInputDto {

    @Schema(description = "ID of the brand", example = "1")
    private Integer brandId;

    @Schema(description = "Start date of the product price", example = "2023-06-21 10:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Schema(description = "End date of the product price", example = "2023-06-30 10:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Schema(description = "ID of the price list", example = "1")
    private Integer priceList;

    @Schema(description = "ID of the product", example = "1")
    private Long productId;

    @Schema(description = "Priority of the product price", example = "1")
    private Integer priority;

    @Schema(description = "Price of the product", example = "9.99")
    private Double price;

    @Schema(description = "Currency of the price", example = "USD")
    private String currency;

}
