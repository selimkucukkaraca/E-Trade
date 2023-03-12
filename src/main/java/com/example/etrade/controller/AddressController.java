package com.example.etrade.controller;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.request.CreateAddressRequest;
import com.example.etrade.service.AddressService;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<AddressDto> save(CreateAddressRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.save(request));
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
