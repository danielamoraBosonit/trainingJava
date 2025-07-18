package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.training.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class DeleteWorkingCalendarController {

    private final DeleteWorkingCalendarUseCase useCase;

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a working calendar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseStatus.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) })
    })
    public void deleteById(@PathVariable Integer id){

        useCase.delete(id);
    }

}
