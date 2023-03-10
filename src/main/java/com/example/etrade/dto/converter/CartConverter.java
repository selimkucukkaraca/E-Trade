package com.example.etrade.dto.converter;

import com.example.etrade.dto.CartDto;
import com.example.etrade.dto.ProductDto;
import com.example.etrade.model.Cart;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartConverter {

    private final ProductConverter productConverter;
    private final UserConverter userConverter;

    public CartConverter(ProductConverter productConverter, UserConverter userConverter) {
        this.productConverter = productConverter;
        this.userConverter = userConverter;
    }

    public CartDto convert(Cart from){
        List<ProductDto> productDtos = from.getProduct()
                .stream()
                .map(productConverter::convert).toList();
        return new CartDto(
                productDtos,
                userConverter.convert(from.getUser())
        );
    }

}