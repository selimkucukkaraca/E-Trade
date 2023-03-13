package com.example.etrade.dto.converter;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public AddressDto convertToDto(Address from){
        return new AddressDto(
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                from.getApartmentNumber(),
                from.getPhoneNumber()
        );
    }

    public Address toEntity(CreateAddressRequest request){
        return new Address(
                request.getCity(),
                request.getDistrict(),
                request.getStreet(),
                request.getApartmentNumber(),
                request.getPhoneNumber()
        );
    }
}
