package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.model.BankAccount;
import com.example.etrade.repository.BankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankAccountServiceTest extends TestUtil {

    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;

    @BeforeEach
    public void setUp() {
        bankAccountRepository = mock(BankAccountRepository.class);
        bankAccountService = new BankAccountService(bankAccountRepository);
    }

    @Test
    public void saveBankAccount_itShouldReturnBankAccount() {

        BankAccount bankAccount = getBankAccountList().get(0);

        when(bankAccountRepository.save(bankAccount)).thenReturn(bankAccount);

        bankAccountService.save(bankAccount);

        assertEquals("test", bankAccount.getCardNumber());

    }

    @Test
    public void getByCardNumber_itShouldReturnBankAccount() {

        BankAccount bankAccount = getBankAccountList().get(0);
        String cardNumber = "test";

        when(bankAccountRepository.findBankAccountByCardNumber(cardNumber)).thenReturn(bankAccount);

        BankAccount response = bankAccountService.getByCardNumber(cardNumber);
        assertEquals(cardNumber, response.getCardNumber());
        verify(bankAccountRepository).findBankAccountByCardNumber(cardNumber);

    }
}