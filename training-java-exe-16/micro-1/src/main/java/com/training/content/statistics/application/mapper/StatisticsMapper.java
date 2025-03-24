package com.training.content.statistics.application.mapper;

import com.training.content.statistics.domain.entity.Statistics;
import com.training.content.statistics.infrastructure.repository.dto.StatisticsInputDto;
import com.training.content.statistics.infrastructure.repository.dto.StatisticsOutputDto;
import com.training.content.statistics.infrastructure.repository.jpa.entity.StatisticsJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    Statistics jpaToDomain(StatisticsJpa statisticsJpa);

    StatisticsJpa domainToJpa(Statistics statistics);

    @Mapping(source = "productId.id", target = "productId")
    StatisticsOutputDto domainToOutputDto(Statistics statistics);

    @Mapping(source = "productId", target = "productId.id")
    Statistics inputToDomain(StatisticsInputDto inputDto);




}
