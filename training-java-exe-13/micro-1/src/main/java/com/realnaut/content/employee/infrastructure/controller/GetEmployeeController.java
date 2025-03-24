package com.realnaut.content.employee.infrastructure.controller;

import com.realnaut.content.employee.application.GetEmployeeUseCase;
import com.realnaut.content.employee.application.mapper.EmployeeMapper;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.infrastructure.controller.dto.EmployeeOutputDto;
import com.realnaut.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class GetEmployeeController {

    private final GetEmployeeUseCase useCase;

    private final EmployeeMapper mapper;


    @GetMapping("/")
    @Operation(summary = "Get all Employees in database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EmployeeOutputDto.class)))
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
    public List<EmployeeOutputDto> getAll(@Parameter(name = "department", description = "department", example = "Desarrollo")
                                            @RequestParam String department,
                                          @Parameter(name = "category", description = "category", example = "Senior")
                                            @RequestParam String category){

        List<Employee> employeeList = useCase.getAll(department, category);

        return employeeList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a Employee by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeOutputDto.class))
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
    public EmployeeOutputDto getById(@Parameter(name = "id", description = "object Id", example = "1")
                                         @PathVariable Integer id){

        Employee employee = useCase.getById(id);

        return mapper.domainToOutputDto(employee);
    }


    @GetMapping("/state/{state}")
    @Operation(summary = "Get all Employees by state",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EmployeeOutputDto.class)))
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
    public List<EmployeeOutputDto> getAllByState(@PathVariable String state){

        List<Employee> employeeList = useCase.getByState(state);

        return employeeList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }

}
