package com.training;

import com.training.content.product.domain.entity.Product;
import com.training.content.product.infrastructure.repository.jpa.entity.ProductJpa;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;

import java.time.LocalDateTime;

public class TestData {


    public static ProductPrice getProductPrice0(){
        return ProductPrice.builder()
                .productId(getProduct1())
                .priceList(4)
                .brandId(52)
                .startDate(LocalDateTime.of(2022, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2022, 11, 30, 23, 0, 0))
                .priority(3)
                .price(7.5)
                .currency("USD")
                .build();
    }


    public static ProductPrice getProductPrice1(){
        return ProductPrice.builder()
                .id(1L)
                .productId(getProduct2())
                .priceList(2)
                .brandId(52)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(50.0)
                .currency("EUR")
                .build();
    }


    public static ProductPrice getProductPrice2(){
        return ProductPrice.builder()
                .id(2L)
                .productId(getProduct3())
                .priceList(2)
                .brandId(652)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(10.0)
                .currency("EUR")
                .build();
    }


    public static ProductPrice getProductPrice3(){
        return ProductPrice.builder()
                .id(3L)
                .productId(getProduct4())
                .priceList(2)
                .brandId(52)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(50.0)
                .currency("EUR")
                .build();
    }


    public static ProductPrice getProductPrice4(){
        return ProductPrice.builder()
                .id(4L)
                .productId(getProduct3())
                .priceList(3)
                .brandId(15)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(25.23)
                .currency("USD")
                .build();
    }


    public static ProductPriceJpa getProductPriceJpa1(){
        return ProductPriceJpa.builder()
                .id(1L)
                .productId(getProductJpa1())
                .priceList(2)
                .brandId(52)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(50.0)
                .curr("EUR")
                .build();
    }


    public static ProductPriceJpa getProductPriceJpa2(){
        return ProductPriceJpa.builder()
                .id(2L)
                .productId(getProductJpa2())
                .priceList(2)
                .brandId(652)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(10.0)
                .curr("EUR")
                .build();
    }


    public static ProductPriceJpa getProductPriceJpa3(){
        return ProductPriceJpa.builder()
                .id(3L)
                .productId(getProductJpa3())
                .priceList(2)
                .brandId(52)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(50.0)
                .curr("EUR")
                .build();
    }


    public static ProductPriceJpa getProductPriceJpa4(){
        return ProductPriceJpa.builder()
                .id(4L)
                .productId(getProductJpa4())
                .priceList(3)
                .brandId(15)
                .startDate(LocalDateTime.of(2023, 5, 4, 10, 0, 0))
                .endDate(LocalDateTime.of(2023, 11, 30, 23, 0, 0))
                .priority(1)
                .price(25.23)
                .curr("USD")
                .build();
    }


    public static Product getProduct1(){
        return Product.builder()
                .id(1L)
                .unitsBox(12)
                .packaging("CRAFT")
                .creationDate(LocalDateTime.of(2021, 5, 4, 10, 0, 0))
                .build();
    }


    public static Product getProduct2(){
        return Product.builder()
                .id(2L)
                .unitsBox(5)
                .packaging("CRAFT")
                .creationDate(LocalDateTime.of(2022, 5, 4, 10, 0, 0))
                .build();
    }

    public static Product getProduct3(){
        return Product.builder()
                .id(3L)
                .unitsBox(12)
                .packaging("PLASTIC")
                .creationDate(LocalDateTime.of(2020, 5, 4, 10, 0, 0))
                .build();
    }

    public static Product getProduct4(){
        return Product.builder()
                .id(4L)
                .unitsBox(12)
                .packaging("CRAFT")
                .creationDate(LocalDateTime.of(2022, 5, 4, 10, 0, 0))
                .build();
    }

    public static ProductJpa getProductJpa1(){
        return ProductJpa.builder()
                .id(1L)
                .unitsBox(12)
                .packaging("CRAFT")
                .creationDate(LocalDateTime.of(2021, 5, 4, 10, 0, 0))
                .build();
    }


    public static ProductJpa getProductJpa2(){
        return ProductJpa.builder()
                .id(2L)
                .unitsBox(5)
                .packaging("CRAFT")
                .creationDate(LocalDateTime.of(2022, 5, 4, 10, 0, 0))
                .build();
    }

    public static ProductJpa getProductJpa3(){
        return ProductJpa.builder()
                .id(3L)
                .unitsBox(12)
                .packaging("PLASTIC")
                .creationDate(LocalDateTime.of(2020, 5, 4, 10, 0, 0))
                .build();
    }

    public static ProductJpa getProductJpa4(){
        return ProductJpa.builder()
                .id(4L)
                .unitsBox(12)
                .packaging("CRAFT")
                .creationDate(LocalDateTime.of(2022, 5, 4, 10, 0, 0))
                .build();
    }
}
