package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.SellerDto;
import com.example.etrade.dto.request.CreateSellerRequest;
import com.example.etrade.model.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SellerConverterTest extends TestUtil {

    private SellerConverter sellerConverter;

    @BeforeEach
    public void setUp(){
        sellerConverter = mock(SellerConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnSellerDto(){
        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);

        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);

        SellerDto response = sellerConverter.convertToDto(seller);

        assertEquals(response,sellerDto);
    }

    @Test
    public void toEntity_isShouldReturnSeller() {
        CreateSellerRequest request = getCreateSellerRequest();
        Seller seller = getSellerList().get(0);

        when(sellerConverter.toEntity(request)).thenReturn(seller);

        Seller response = sellerConverter.toEntity(request);

        assertEquals(seller,response);
    }
}