package com.example.etrade.repository;

import com.example.etrade.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findBankAccountByCardNumber(String cardNumber);

}