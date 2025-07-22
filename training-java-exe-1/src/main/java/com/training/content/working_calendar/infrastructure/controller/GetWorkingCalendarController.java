package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarFilters;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.training.error.CustomErrorResponse;
import com.training.shared.criteria.CriteriaJpaBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class GetWorkingCalendarController {

    private final GetWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;

    @GetMapping("/")
    @Operation(summary = "Get all working calendars from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = WorkingCalendarOutputDto.class))) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) })
    })
    public List<WorkingCalendarOutputDto> getAll(@RequestBody(required = false) WorkingCalendarFilters filters){

        List<WorkingCalendar> workingCalendarList = useCase.getAll(filters);

        return workingCalendarList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a working calendar by id")
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
    public WorkingCalendarOutputDto getById(@PathVariable Integer id){

        WorkingCalendar workingCalendar = useCase.getById(id);

        return mapper.domainToOutputDto(workingCalendar);
    }




}
