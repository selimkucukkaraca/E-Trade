package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.converter.CartConverter;
import com.example.etrade.model.ConfirmedCart;
import com.example.etrade.repository.ConfirmedCartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConfirmedCardServiceTest extends TestUtil {

    private ConfirmedCartRepository confirmedCartRepository;
    private CartConverter cartConverter;
    private ConfirmedCardService confirmedCardService;

    @BeforeEach
    public void setUp() {
        confirmedCartRepository = mock(ConfirmedCartRepository.class);
        cartConverter = mock(CartConverter.class);
        confirmedCardService = new ConfirmedCardService(confirmedCartRepository, cartConverter);
    }

    @Test
    public void saveConfirmedCart_itShouldReturnConfirmedCart(){
        ConfirmedCart confirmedCart = getConfirmedCartList().get(0);

        when(confirmedCartRepository.save(confirmedCart)).thenReturn(confirmedCart);

        ConfirmedCart response = confirmedCardService.save(confirmedCart);

        assertEquals(confirmedCart,response);
        verify(confirmedCartRepository).save(confirmedCart);
    }

    @Test
    public void getAll_itShouldReturnConfirmedCartDtoList(){

    }

    @Test
    public void toDto_itShouldReturnConfirmedCartDto(){

    }


}