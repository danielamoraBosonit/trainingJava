package com.training.content.product_price.infrastructure.controller;

import com.training.content.product_price.application.CreateProductPriceUseCase;
import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceInputDto;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
import com.training.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product-price")
public class CreateProductPriceController {

    private final CreateProductPriceUseCase useCase;

    private final ProductPriceMapper mapper;


    @PostMapping("/")
    @Operation(summary = "Create a ProductPrice object",
        responses = {
                @ApiResponse(responseCode = "200", description = "OK",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProductPriceOutputDto.class))
                ),
                @ApiResponse(responseCode = "400", description = "Bad Request",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = CustomErrorResponse.class))
                ),
                @ApiResponse(responseCode = "500", description = "Internal Server Error",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = CustomErrorResponse.class))
                ),
        })
    public ProductPriceOutputDto create(@RequestBody ProductPriceInputDto inputDto){

        ProductPrice productPriceFromInput = mapper.inputDtoToDomain(inputDto);

        ProductPrice productPriceReturned = useCase.create(productPriceFromInput);

        return mapper.domainToOutputDto(productPriceReturned);
    }

}
