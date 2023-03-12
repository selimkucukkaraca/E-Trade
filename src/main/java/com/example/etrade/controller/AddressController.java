package com.example.etrade.controller;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> getAddressByAddressId(@PathVariable String addressId){
        return ResponseEntity
                .ok(addressService.getAddressByAddressId(addressId));
    }
}