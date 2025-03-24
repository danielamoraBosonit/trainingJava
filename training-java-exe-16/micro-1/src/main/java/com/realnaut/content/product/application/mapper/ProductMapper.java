package com.realnaut.content.product.application.mapper;

import com.realnaut.content.product.domain.entity.Product;
import com.realnaut.content.product.infrastructure.controller.dto.ProductOutputDto;
import com.realnaut.content.product.infrastructure.controller.dto.ProductOutputVO;
import com.realnaut.content.product.infrastructure.repository.jpa.entity.ProductJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product jpaToDomain(ProductJpa productJpa);

    ProductOutputDto domainToOutputDto(Product product);

    ProductOutputVO domainToVO(Product product);

}
