package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.converter.AddressConverter;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.model.Address;
import com.example.etrade.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest extends TestUtil {

    private AddressRepository addressRepository;
    private AddressConverter addressConverter;
    private UserService userService;
    private AddressService addressService;

    @BeforeEach
    public void setUp(){
        addressRepository = mock(AddressRepository.class);
        addressConverter = mock(AddressConverter.class);
        userService = mock(UserService.class);
        addressService = new AddressService(addressRepository,addressConverter,userService);
    }

    @Test
    public void saveAddress_itShouldReturnAddressDto(){

        CreateAddressRequest request = getCreateAddressRequest();
        Address address = getAddressList().get(0);

        when(addressConverter.toEntity(request)).thenReturn(address);
        when(addressRepository.save(address)).thenReturn(address);

        Address response = addressService.save(request);

        assertEquals(response,address);
        verify(addressConverter).toEntity(request);
        verify(addressRepository).save(address);

    }

    @Test
    public void getAddressByAddressId_itShouldReturnAddressDto(){

        AddressDto addressDto = getAddressDtoList().get(0);
        String addressId = "test";

        when(addressRepository.findAddressByAddressId(addressId)).thenReturn(Optional.ofNullable(addressDto));

        AddressDto response = addressService.getAddressByAddressId(addressId);

        assertEquals(response,addressDto);
        verify(addressRepository).findAddressByAddressId(addressId);
    }

    /*
    @Test
    public void getAddressListByUserMail_itShouldReturnAddressDtoList(){
        List<AddressDto> addressDtoList = getAddressDtoList();
        List<Address> addressList = getAddressList();

    }
    */

    //TODO delete

}