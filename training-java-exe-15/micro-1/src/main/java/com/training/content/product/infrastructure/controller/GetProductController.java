package com.training.content.product.infrastructure.controller;

import com.training.content.product.application.GetProductUseCase;
import com.training.content.product.application.mapper.ProductMapper;
import com.training.content.product.domain.entity.Product;
import com.training.content.product.infrastructure.controller.dto.ProductOutputDto;
import com.training.content.product.infrastructure.controller.dto.ProductOutputVO;
import com.training.error.CustomErrorResponse;
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
@RequestMapping("/api/product")
public class GetProductController {

    private final GetProductUseCase useCase;

    private final ProductMapper mapper;


    @GetMapping("/")
    @Operation(summary = "Get all Products in database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductOutputDto.class)))
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
    public List<ProductOutputDto> getAll(@Parameter(name = "packaging", description = "packaging", example = "PLASTIC")
                                            @RequestParam String packaging,
                                         @Parameter(name = "unitsBox", description = "unitsBox", example = "12")
                                            @RequestParam Integer unitsBox){

        List<Product> productList = useCase.getAll(packaging, unitsBox);

        return productList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a Product by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductOutputDto.class))
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
    public ProductOutputDto getById(@Parameter(name = "id", description = "object Id", example = "1")
                                         @PathVariable Integer id){

        Product product = useCase.getById(id.longValue());

        return mapper.domainToOutputDto(product);
    }


    @GetMapping("/statistics")
    @Operation(summary = "Get Products statistics",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductOutputDto.class)))
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
    public List<ProductOutputVO> getProductsStatistics(@RequestBody List<Integer> productIds){

        return useCase.getProductsStatistics(productIds);

    }

}
