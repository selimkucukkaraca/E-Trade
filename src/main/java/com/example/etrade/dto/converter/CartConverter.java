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

    public CartDto convertToDto(Cart from){
        List<ProductDto> productDto = from.getProduct()
                .stream()
                .map(productConverter::convertToDto).toList();
        return new CartDto(
                productDto,
                userConverter.convertToDto(from.getUser())
        );
    }

}