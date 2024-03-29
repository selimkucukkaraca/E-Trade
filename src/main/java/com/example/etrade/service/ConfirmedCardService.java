package com.example.etrade.service;

import com.example.etrade.dto.ConfirmedCartDto;
import com.example.etrade.dto.converter.CartConverter;
import com.example.etrade.model.ConfirmedCart;
import com.example.etrade.repository.ConfirmedCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @CachePut(value = "confirmedCards", key = "#confirmedCart")
    public ConfirmedCart save(ConfirmedCart confirmedCart) {
        log.info("cart info:" + confirmedCart);
        return confirmedCartRepository.save(confirmedCart);
    }

    @Cacheable(value = "confirmedCards", key = "#page and #size")
    public List<ConfirmedCartDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        System.out.println("custom log : " + confirmedCartRepository.findAll());
        return confirmedCartRepository.findAll(pageable)
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