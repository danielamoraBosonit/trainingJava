package com.training.content.employee.infrastructure.controller;

import com.training.content.employee.application.GetEmployeeUseCase;
import com.training.content.employee.application.mapper.EmployeeMapper;
import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.infrastructure.controller.dto.EmployeeOutputDto;
import com.training.error.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
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
    @Operation(summary = "Get all employees by department and category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeOutputDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) })
    })
    public List<EmployeeOutputDto> getAll(@Parameter(name = "department", description = "department", example = "Desarrollo")
                                              @RequestParam String department,
                                          @Parameter(name = "category", description = "category", example = "Senior")
                                              @RequestParam String category) {
        List<Employee> employees = useCase.getAll(department, category);

        return employees.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeOutputDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomErrorResponse.class)) })
    })
    public EmployeeOutputDto getById(@PathVariable Integer id) {
        Employee employee = useCase.getById(id);

        return mapper.domainToOutputDto(employee);
    }
}
