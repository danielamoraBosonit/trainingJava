package com.training.content.sale.application.mapper;

import com.training.content.sale.domain.entity.Sale;
import com.training.content.sale.infrastructure.controller.dto.SaleInputDto;
import com.training.content.sale.infrastructure.controller.dto.SaleOutputDto;
import com.training.content.sale.infrastructure.repository.mongo.entity.SaleMongoDB;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale mongoDbToDomain(SaleMongoDB saleMongoDB);

    SaleOutputDto domainToOutputDto(Sale Sale);

    Sale inputDtoToDomain(SaleInputDto inputDto);

    SaleMongoDB domainToMongoDB(Sale sale);

}
