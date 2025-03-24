package com.realnaut.content.product_price.infrastructure.controller;

import com.realnaut.content.product_price.application.GetProductPriceUseCase;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceFilters;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
import com.realnaut.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product-price")
public class GetProductPriceController {

    private final GetProductPriceUseCase useCase;

    private final ProductPriceMapper mapper;


    @GetMapping("/")
    @Operation(summary = "Get all ProductPrice objects in database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductPriceOutputDto.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomErrorResponse.class))
                    ),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CustomErrorResponse.class))
                    ),
            })
    public List<ProductPriceOutputDto> getAll(@RequestBody (required = false) ProductPriceFilters filters){

        List<ProductPrice> productPriceList = useCase.getAll(filters);

        return productPriceList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a ProductPrice object by id",
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
    public ProductPriceOutputDto getById(@Parameter(name = "id", description = "object Id", example = "1")
                                         @PathVariable Integer id){

        ProductPrice productPrice = useCase.getById(id.longValue());

        return mapper.domainToOutputDto(productPrice);
    }

}
