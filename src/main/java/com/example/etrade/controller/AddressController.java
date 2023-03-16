package com.example.etrade.controller;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@CrossOrigin
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String addressId){
        addressService.delete(addressId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/get-address-by-address-id/{addressId}")
    public ResponseEntity<AddressDto> getAddressByAddressId(@PathVariable String addressId){
        return ResponseEntity
                .ok(addressService.getAddressByAddressId(addressId));
    }

    @GetMapping("/get-address-by-user-mail/{mail}")
    public ResponseEntity<List<AddressDto>> getAddressListByUserMail(@PathVariable String mail){
        return ResponseEntity
                .ok(addressService.getAddressListByUserMail(mail));
    }
}