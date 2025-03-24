package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.realnaut.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class GetWorkingCalendarController {

    private final GetWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;



    @GetMapping("/")
    @Operation(summary = "Get all Working Calendars in database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = WorkingCalendarOutputDto.class)))
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
    public List<WorkingCalendarOutputDto> getAll(){

        List<WorkingCalendar> workingCalendarList = useCase.getAll();

        return workingCalendarList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a Working Calendar by id",
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
    public WorkingCalendarOutputDto getById(@PathVariable Integer id){

        WorkingCalendar workingCalendar = useCase.getById(id);

        return mapper.domainToOutputDto(workingCalendar);
    }




}
