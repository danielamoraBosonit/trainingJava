package com.training.content.product.application.mapper;

import com.training.content.product.domain.entity.Product;
import com.training.content.product.infrastructure.controller.dto.ProductOutputDto;
import com.training.content.product.infrastructure.controller.dto.ProductOutputVO;
import com.training.content.product.infrastructure.repository.jpa.entity.ProductJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product jpaToDomain(ProductJpa productJpa);

    ProductOutputDto domainToOutputDto(Product product);

    ProductOutputVO domainToVO(Product product);

}
