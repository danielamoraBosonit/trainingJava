package com.training.content.time_clock.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeClockInputDto {

    private String email;

    private String type;

}
