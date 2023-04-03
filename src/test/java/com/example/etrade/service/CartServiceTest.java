package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.converter.CartConverter;
import com.example.etrade.model.Cart;
import com.example.etrade.repository.CartRepository;
import com.example.etrade.repository.ProductRepository;
import com.example.etrade.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest extends TestUtil {

    private CartRepository cartRepository;
    private CartConverter cartConverter;
    private UserService userService;
    private ProductService productService;
    private CartService cartService;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        cartRepository = mock(CartRepository.class);
        cartConverter = mock(CartConverter.class);
        userService = mock(UserService.class);
        productService = mock(ProductService.class);
        userRepository = mock(UserRepository.class);
        productRepository = mock(ProductRepository.class);
        cartService = new CartService(cartRepository, cartConverter, userService, productService);
    }

    @Test
    public void getCart_itShouldReturnCart() {

        Cart cart = getCartList(null, null).get(0);
        String cartId = "test";

        when(cartRepository.findCartByCartId(cartId)).thenReturn(cart);

        Cart response = cartService.getCart(cartId);

        assertEquals(response, cart);
        verify(cartRepository).findCartByCartId(cartId);

    }

    @Test
    public void deleteByCartId() {

        Cart cart = getCartList(null, null).get(0);
        String cartId = "test";

        when(cartRepository.findCartByCartId(cartId)).thenReturn(cart);

        cartService.deleteByCartId(cartId);

        verify(cartRepository).delete(cart);

    }
}