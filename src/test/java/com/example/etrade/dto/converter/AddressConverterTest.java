package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressConverterTest extends TestUtil {

    private AddressConverter addressConverter;

    @BeforeEach
    public void setUp() {
        addressConverter = mock(AddressConverter.class);
    }

    @Test
    public void testConvertToDto_itShouldReturnAddressDto() {
        Address address = getAddressList().get(0);
        AddressDto addressDto = getAddressDtoList().get(0);

        when(addressConverter.convertToDto(address)).thenReturn(addressDto);

        AddressDto response = addressConverter.convertToDto(address);

        assertEquals(response, addressDto);
    }

    @Test
    public void testToEntity_isShouldReturnAddress() {
        CreateAddressRequest request = getCreateAddressRequest();
        Address address = getAddressList().get(0);

        when(addressConverter.toEntity(request)).thenReturn(address);

        Address response = addressConverter.toEntity(request);

        assertEquals(address, response);
    }
}