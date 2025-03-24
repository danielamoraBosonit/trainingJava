package com.realnaut.content.product.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "OutputDto for recover a product")
public class ProductOutputDto {

    @Schema(description = "ID of the Product", example = "1")
    private Long id;

    @Schema(description = "Description of the product", example = "Shirt")
    private String description;

    @Schema(description = "Creation date of the product", example = "2023-06-30 10:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;

    @Schema(description = "Units in box for product", example = "12")
    private Integer unitsBox;

    @Schema(description = "Type of packaging for product", example = "PLASTIC")
    private String packaging;

}
