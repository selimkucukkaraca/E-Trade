package com.example.etrade.service;

import com.example.etrade.dto.CartDto;
import com.example.etrade.dto.converter.CartConverter;
import com.example.etrade.model.Cart;
import com.example.etrade.model.Product;
import com.example.etrade.repository.CartRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartConverter cartConverter;
    private final UserService userService;
    private final ProductService productService;

    public CartService(CartRepository cartRepository, CartConverter cartConverter,
                       UserService userService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartConverter = cartConverter;
        this.userService = userService;
        this.productService = productService;
    }

    @CachePut(value = "carts", key = "#productId")
    public CartDto save(String mail, String productId) {
        var fromUser = userService.getUserByMail(mail);
        var fromProduct = productService.getProductObjectByProductId(productId);
        List<Product> products = List.of(fromProduct);

        Cart cart = new Cart(products, fromUser);
        fromProduct.setStock(fromProduct.getStock() - 1);
        cartRepository.save(cart);
        productService.updateProduct(fromProduct);
        return cartConverter.convertToDto(cart);
    }

    protected Cart getCart(String cartId) {
        return cartRepository.findCartByCartId(cartId);
    }

    @CacheEvict(value = "carts", key = "#cartId")
    public void deleteByCartId(String cartId) {
        var fromCart = getCart(cartId);
        cartRepository.delete(fromCart);
    }
}