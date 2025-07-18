package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.training.error.CustomErrorResponse;
import com.training.error.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Fully Update a working calendar")
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
    public WorkingCalendarOutputDto update(@PathVariable Integer id, @RequestBody WorkingCalendarInputDto workingCalendarInputDto) throws CustomException {

        WorkingCalendar workingCalendarFromInput = mapper.inputDtoToDomain(workingCalendarInputDto);
        workingCalendarFromInput.setId(id);

        WorkingCalendar workingCalendar = useCase.updateWorkingCalendar(workingCalendarFromInput);

        return mapper.domainToOutputDto(workingCalendar);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Partial Update a working calendar")
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
    public WorkingCalendarOutputDto patchUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) throws CustomException {

        WorkingCalendar workingCalendar = useCase.patchUpdateWorkingCalendar(id, fields);

        return mapper.domainToOutputDto(workingCalendar);
    }


}
