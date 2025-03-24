package com.realnaut.content.statistics.application.mapper;

import com.realnaut.content.statistics.domain.entity.Statistics;
import com.realnaut.content.statistics.infrastructure.repository.dto.StatisticsInputDto;
import com.realnaut.content.statistics.infrastructure.repository.dto.StatisticsOutputDto;
import com.realnaut.content.statistics.infrastructure.repository.jpa.entity.StatisticsJpa;
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
