package com.example.etrade.dto.converter;

import com.example.etrade.dto.SellerDto;
import com.example.etrade.dto.request.CreateSellerRequest;
import com.example.etrade.model.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerConverter {

    public SellerDto convertToDto(Seller from){
        return new SellerDto(
                from.getUsername(),
                from.getMail(),
                from.getImageUrl(),
                from.isActive()
        );
    }

    public Seller toEntity(CreateSellerRequest request){
        return new Seller(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                request.getImageUrl()
        );
    }
}