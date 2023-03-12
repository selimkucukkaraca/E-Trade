package com.example.etrade.service;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.converter.AddressConverter;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.model.Address;
import com.example.etrade.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;

    public AddressService(AddressRepository addressRepository, AddressConverter addressConverter) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
    }

    public Address save(CreateAddressRequest request){
        var saved = addressConverter.toEntity(request);
        return addressRepository.save(saved);
    }

    public void delete(String addressId){
        var fromAddress = getAddressByAddressId(addressId);
        addressRepository.deleteAddressByAddressId(String.valueOf(fromAddress));
    }

    public AddressDto getAddressByAddressId(String addressId){
        return addressRepository.findAddressByAddressId(addressId)
                .orElseThrow(()-> new RuntimeException(""));
    }
}