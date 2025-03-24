package com.realnaut.content.product_price.infrastructure.controller;

import com.realnaut.content.product_price.application.UpdateProductPriceUseCase;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceInputDto;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
import com.realnaut.error.CustomErrorResponse;
import com.realnaut.error.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping("/api/product-price")
public class UpdateProductPriceController {

    private final UpdateProductPriceUseCase useCase;

    private final ProductPriceMapper mapper;


    @PutMapping("/{id}")
    @Operation(summary = "Fully Update a ProductPrice object",
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
    public ProductPriceOutputDto update(@Parameter(name = "id", description = "object Id", example = "1")
                                            @PathVariable Integer id,
                                        @RequestBody ProductPriceInputDto inputDto) throws CustomException {

        ProductPrice productPrice = mapper.inputDtoToDomain(inputDto);
        productPrice.setId(Long.valueOf(id));

        ProductPrice productPriceUpdated = useCase.update(productPrice);

        return mapper.domainToOutputDto(productPriceUpdated);
    }


    @PatchMapping("/{id}")
    @Operation(summary = "Partial Update a ProductPrice object",
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
    public ProductPriceOutputDto patchUpdate(@Parameter(name = "id", description = "object Id", example = "1")
                                                @PathVariable Integer id,
                                             @Parameter(name = "fields", description = "fields map")
                                                @RequestBody Map<String, Object> fields) throws CustomException {

        ProductPrice productPrice = useCase.patchUpdate(Long.valueOf(id), fields);

        return mapper.domainToOutputDto(productPrice);
    }


}
