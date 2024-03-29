package com.example.etrade.repository;

import com.example.etrade.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findAddressByAddressId(String addressId);

    Optional<Address> getAddressByAddressId(String id);

}