package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.PromoCodeDto;
import com.example.etrade.dto.request.CreatePromoCodeRequest;
import com.example.etrade.model.PromoCode;
import com.example.etrade.model.User;
import com.example.etrade.repository.PromoCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PromoCodeServiceTest extends TestUtil {

    private PromoCodeRepository promoCodeRepository;
    private UserService userService;
    private PromoCodeService promoCodeService;

    @BeforeEach
    public void setUp(){
        promoCodeRepository = mock(PromoCodeRepository.class);
        userService = mock(UserService.class);
        promoCodeService = new PromoCodeService(promoCodeRepository,userService);
    }

    @Test
    public void savePromoCode_itShouldReturnPromoCodeDto(){
        //TODO
    }

    @Test
    public void getByCodeText_itShouldReturnPromoCode(){
        PromoCode promoCode = getPromoCodeList().get(0);

        when(promoCodeRepository.findPromoCodeByCodeText("test")).thenReturn(Optional.ofNullable(promoCode));

        PromoCode response = promoCodeService.getByCodeText("test");

        assertEquals(response,promoCode);
        verify(promoCodeRepository).findPromoCodeByCodeText("test");
    }

    @Test
    public void getByPublicId_itShouldReturnByPublicId(){
        PromoCode promoCode = getPromoCodeList().get(0);

        when(promoCodeRepository.findPromoCodeByPublicId("test")).thenReturn(Optional.ofNullable(promoCode));

        PromoCode response = promoCodeService.getByPublicId("test");

        assertEquals(response,promoCode);
        verify(promoCodeRepository).findPromoCodeByPublicId("test");
    }

    @Test
    public void delete(){
        PromoCode promoCode = getPromoCodeList().get(0);
        String publicId = "test";

        when(promoCodeRepository.findPromoCodeByPublicId(publicId)).thenReturn(Optional.ofNullable(promoCode));

        promoCodeService.delete(publicId);

        assert promoCode != null;
        verify(promoCodeRepository).delete(promoCode);
    }

    @Test
    public void toDto_itShouldReturnPromoCodeDto(){
        //TODO
    }
}