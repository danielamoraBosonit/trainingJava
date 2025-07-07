package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.training.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class CreateWorkingCalendarController {

    private final CreateWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;

    @PostMapping("/")
    @Operation(summary = "Create a working calendar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = WorkingCalendarOutputDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) })
    })
    public WorkingCalendarOutputDto createWorkingCalendar(@RequestBody WorkingCalendarInputDto workingCalendarInputDto) {
        WorkingCalendar workingCalendar = useCase.createWorkingCalendar(workingCalendarInputDto);

        return mapper.domainToOutputDto(workingCalendar);
    }

}
