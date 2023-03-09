package com.example.etrade.service;

import com.example.etrade.model.ConfirmCode;
import com.example.etrade.repository.ConfirmCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmCodeService {

    private final ConfirmCodeRepository confirmCodeRepository;

    public ConfirmCodeService(ConfirmCodeRepository confirmCodeRepository) {
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public void delete(ConfirmCode confirmCode){
        confirmCodeRepository.delete(confirmCode);
    }

    public void save(ConfirmCode confirmCode){
        confirmCodeRepository.save(confirmCode);
    }
}