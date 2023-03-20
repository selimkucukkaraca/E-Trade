package com.example.etrade.repository;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Long> {

    Optional<AddressDto> findAddressByAddressId(String addressId);
    Optional<Address> getAddressByAddressId(String id);
}