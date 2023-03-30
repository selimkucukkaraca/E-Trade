package com.example.etrade.service;

import com.example.etrade.model.ConfirmCode;
import com.example.etrade.repository.ConfirmCodeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class ConfirmCodeService {

    private final ConfirmCodeRepository confirmCodeRepository;

    public ConfirmCodeService(ConfirmCodeRepository confirmCodeRepository) {
        this.confirmCodeRepository = confirmCodeRepository;
    }

    @CacheEvict(value = "confirmCodes", key = "#confirmCode")
    public void delete(ConfirmCode confirmCode) {
        confirmCodeRepository.delete(confirmCode);
    }

    @CachePut(value = "confirmCodes", key = "#confirmCode")
    public void save(ConfirmCode confirmCode) {
        confirmCodeRepository.save(confirmCode);
    }
}