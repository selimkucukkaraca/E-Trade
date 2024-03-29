package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.model.ConfirmCode;
import com.example.etrade.repository.ConfirmCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConfirmCodeServiceTest extends TestUtil {

    private ConfirmCodeRepository confirmCodeRepository;
    private ConfirmCodeService confirmCodeService;

    @BeforeEach
    public void setUp() {
        confirmCodeRepository = mock(ConfirmCodeRepository.class);
        confirmCodeService = new ConfirmCodeService(confirmCodeRepository);
    }

    @Test
    public void saveConfirmCode() {

        ConfirmCode confirmCode = getConfirmCodeList().get(0);

        when(confirmCodeRepository.save(confirmCode)).thenReturn(confirmCode);

        confirmCodeService.save(confirmCode);

        assertEquals(0, confirmCode.getCode());
        verify(confirmCodeRepository).save(confirmCode);

    }

    @Test
    public void deleteConfirmCode() {

        ConfirmCode confirmCode = getConfirmCodeList().get(0);

        confirmCodeService.delete(confirmCode);

        verify(confirmCodeRepository).delete(confirmCode);

    }
}