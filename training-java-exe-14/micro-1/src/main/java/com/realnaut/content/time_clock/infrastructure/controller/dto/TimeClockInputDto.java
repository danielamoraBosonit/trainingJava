package com.realnaut.content.time_clock.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeClockInputDto {


    private String email;

    private LocalDateTime time;

    private String type;

}
