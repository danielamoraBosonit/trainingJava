package com.training.content.time_clock.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeClockOutputDto {

    private Integer employeeId;

    private LocalDateTime time;

    private String type;

}
