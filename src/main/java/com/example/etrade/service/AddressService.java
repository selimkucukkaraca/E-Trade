package com.example.etrade.service;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.converter.AddressConverter;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.model.Address;
import com.example.etrade.repository.AddressRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final UserService userService;

    public AddressService(AddressRepository addressRepository,
                          AddressConverter addressConverter, UserService userService) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
        this.userService = userService;
    }

    @CachePut(value = "addresses", key = "#request")
    public Address save(CreateAddressRequest request) {
        var saved = addressConverter.toEntity(request);
        return addressRepository.save(saved);
    }

    @CacheEvict(value = "addresses", key = "#addressId")
    public void delete(String addressId) {
        var fromAddress = getAddress(addressId);
        addressRepository.delete(fromAddress);
    }

    @Cacheable(value = "addresses", key = "#addressId")
    public AddressDto getAddressByAddressId(String addressId) {
        var address = addressRepository.findAddressByAddressId(addressId)
                .orElseThrow(() -> new NotFoundException(""));
        return addressConverter.convertToDto(address);
    }

    @Cacheable(value = "addresses", key = "#mail")
    public List<AddressDto> getAddressListByUserMail(String mail) {
        var fromUser = userService.getUserByMail(mail);
        return fromUser.getAddress()
                .stream()
                .map(addressConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "addresses", key = "#addressId")
    public Address getAddress(String addressId) {
        return addressRepository.getAddressByAddressId(addressId)
                .orElseThrow(() -> new RuntimeException(""));
    }
}