package com.example.etrade.service;

import com.example.etrade.dto.ConfirmedCartDto;
import com.example.etrade.dto.converter.CartConverter;
import com.example.etrade.model.ConfirmedCart;
import com.example.etrade.repository.ConfirmedCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConfirmedCardService {

    private final ConfirmedCartRepository confirmedCartRepository;
    private final CartConverter cartConverter;

    public ConfirmedCardService(ConfirmedCartRepository confirmedCartRepository, CartConverter cartConverter) {
        this.confirmedCartRepository = confirmedCartRepository;
        this.cartConverter = cartConverter;
    }

    public ConfirmedCart save(ConfirmedCart confirmedCart) {
        log.info("cart info:" + confirmedCart);
        return confirmedCartRepository.save(confirmedCart);
    }

    public List<ConfirmedCartDto> getAll() {
        return confirmedCartRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ConfirmedCartDto toDto(ConfirmedCart confirmedCart) {
        return new ConfirmedCartDto(
                cartConverter.convertToDto(confirmedCart.getCarts()),
                confirmedCart.getConfirmedId()
        );
    }
}