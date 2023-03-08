package com.example.etrade.dto.converter;

import com.example.etrade.dto.CartDto;
import com.example.etrade.dto.request.CreateCartRequest;
import com.example.etrade.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public CartDto convert(Cart from){
        return new CartDto(
                from.getQuantity(),
                from.getProductName(),
                from.getProductDetails(),
                from.getProductPrice(),
                from.getProductImageUrl()
        );
    }

    public Cart toEntity(CreateCartRequest request){
        return new Cart(
                request.getQuantity(),
                request.getProductName(),
                request.getProductDetails(),
                request.getProductPrice(),
                request.getProductImageUrl()
        );
    }
}