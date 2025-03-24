package com.realnaut.content.product_price.infrastructure.controller;

import com.realnaut.content.product_price.application.DeleteProductPriceUseCase;
import com.realnaut.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product-price")
public class DeleteProductPriceController {

    private final DeleteProductPriceUseCase useCase;

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a ProductPrice object",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseStatus.class))
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
    public void delete(@Parameter(name = "id", description = "object Id", example = "1")
                       @PathVariable Integer id){

        useCase.delete(Long.valueOf(id));

    }

}
