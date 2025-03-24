package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.realnaut.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class UpdateWorkingCalendarController {

    private final UpdateWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;


    @PutMapping("/{id}")
    @Operation(summary = "Fully Update a Working Calendar",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WorkingCalendarOutputDto.class))
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
    public WorkingCalendarOutputDto update(@PathVariable Integer id, @RequestBody WorkingCalendarInputDto inputDto){

        WorkingCalendar workingCalendar = useCase.update(id, inputDto);

        return mapper.domainToOutputDto(workingCalendar);
    }


    @PatchMapping("/{id}")
    @Operation(summary = "Partial Update a Working Calendar",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WorkingCalendarOutputDto.class))
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
    public WorkingCalendarOutputDto patchUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields){

        WorkingCalendar workingCalendar = useCase.patchUpdate(id, fields);

        return mapper.domainToOutputDto(workingCalendar);
    }


}
