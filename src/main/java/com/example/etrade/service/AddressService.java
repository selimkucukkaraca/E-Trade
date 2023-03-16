package com.example.etrade.service;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.converter.AddressConverter;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.model.Address;
import com.example.etrade.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final UserService userService;

    public AddressService(AddressRepository addressRepository,
                          AddressConverter addressConverter,UserService userService) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
        this.userService = userService;
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

    public List<AddressDto> getAddressListByUserMail(String mail){
       var fromUser = userService.getUserByMail(mail);
       return fromUser.getAddress()
               .stream()
               .map(addressConverter::convertToDto)
               .collect(Collectors.toList());
    }
}