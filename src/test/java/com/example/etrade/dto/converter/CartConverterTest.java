package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CartConverterTest extends TestUtil {

    private ProductConverter productConverter;
    private UserConverter userConverter;
    private CartConverter cartConverter;

    @BeforeEach
    public void setUp(){
        productConverter = mock(ProductConverter.class);
        userConverter = mock(UserConverter.class);
        cartConverter = mock(CartConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnCartDto(){
        //TODO
    }

}