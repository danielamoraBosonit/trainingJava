package com.realnaut.content.sale.application.mapper;

import com.realnaut.content.sale.domain.entity.Sale;
import com.realnaut.content.sale.infrastructure.controller.dto.SaleInputDto;
import com.realnaut.content.sale.infrastructure.controller.dto.SaleOutputDto;
import com.realnaut.content.sale.infrastructure.repository.mongo.entity.SaleMongoDB;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale mongoDbToDomain(SaleMongoDB saleMongoDB);

    SaleOutputDto domainToOutputDto(Sale Sale);

    Sale inputDtoToDomain(SaleInputDto inputDto);

    SaleMongoDB domainToMongoDB(Sale sale);

}
