package com.realnaut.content.product_price.application.impl;

import com.realnaut.content.product.domain.entity.Product;
import com.realnaut.content.product_price.application.GetProductPriceUseCase;
import com.realnaut.content.product_price.application.UpdateProductPriceUseCase;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.domain.repository.UpdateProductPriceRepository;
import com.realnaut.error.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;


@AllArgsConstructor
@Service
public class UpdateProductPriceUseCaseImpl implements UpdateProductPriceUseCase {

    private final UpdateProductPriceRepository repo;

    private final GetProductPriceUseCase getProductPriceUseCase;

    private final ProductPriceMapper mapper;


    @Override
    public ProductPrice update(ProductPrice productPrice) throws CustomException {

        return repo.update(productPrice);

    }

    @Override
    public ProductPrice patchUpdate(Long id, Map<String, Object> fields) throws CustomException {

        ProductPrice productPrice = getProductPriceUseCase.getById(id);

        for (Map.Entry<String,Object> entry : fields.entrySet()) {
            if (!entry.getKey().equals("id")){

                if (entry.getKey().equals("productId")){
                    productPrice.setProductId(Product.builder().id((long) (int) entry.getValue()).build());

                } else {
                    Field field = ReflectionUtils.findField(ProductPrice.class, entry.getKey());
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, productPrice, entry.getValue());
                }
            }
        }

        return repo.update(productPrice);
    }
}
