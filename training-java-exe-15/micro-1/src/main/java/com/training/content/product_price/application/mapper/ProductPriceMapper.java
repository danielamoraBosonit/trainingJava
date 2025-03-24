package com.training.content.product_price.application.mapper;

import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceInputDto;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {

    @Mapping(source = "curr", target = "currency")
    ProductPrice jpaToDomain(ProductPriceJpa productPriceJpa);

    @Mapping(source = "productId", target = "productId.id")
    ProductPrice inputDtoToDomain(ProductPriceInputDto inputDto);

    @Mapping(source = "currency", target = "curr")
    ProductPriceJpa domainToJpa(ProductPrice productPrice);

    @Mapping(target = "interval",
            expression = "java(calcInterval(productPrice.getStartDate(), productPrice.getEndDate()))")
    ProductPriceOutputDto domainToOutputDto(ProductPrice productPrice);

    default Integer calcInterval(LocalDateTime startDate, LocalDateTime endDate){
        if (startDate != null && endDate != null){
            Integer interval = (int)ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
            return interval;
        }
        return null;
    }

}
