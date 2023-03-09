package com.example.etrade.service;

import com.example.etrade.model.BankAccount;
import com.example.etrade.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount getByCardNumber(String cardNumber){
        return bankAccountRepository.findBankAccountByCardNumber(cardNumber);
    }

    public BankAccount save(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
}