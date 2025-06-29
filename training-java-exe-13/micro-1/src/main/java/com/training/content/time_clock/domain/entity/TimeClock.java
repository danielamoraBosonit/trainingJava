package com.training.content.time_clock.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeClock {

    private String id;

    private Integer employeeId;

    private LocalDateTime time;

    private String type;

}
