package com.example.etrade.service;

import com.example.etrade.dto.request.ConfirmCartRequest;
import com.example.etrade.model.BankAccount;
import com.example.etrade.repository.BankAccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    protected BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    protected BankAccount getByCardNumber(String cardNumber) {
        return bankAccountRepository.findBankAccountByCardNumber(cardNumber);
    }

    protected boolean validateCreditCard(ConfirmCartRequest request) {
        BankAccount bankAccount = bankAccountRepository.findBankAccountByCardNumber(request.getCardNumber());

        if (bankAccount.getCardNumber().equals(request.getCardNumber())
                && bankAccount.getCvv() == request.getCvv()
                && bankAccount.getNameAndLastname().equals(request.getNameAndSurname())) {
            // && bankAccount.getExpirationDate().equals(request.getExpirationDate())) {    //TODO
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "card not valid");
        }
    }
}