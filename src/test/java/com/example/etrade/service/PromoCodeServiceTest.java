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

   /* @Test
    public void savePromoCode_itShouldReturnPromoCodeDto(){
        CreatePromoCodeRequest request = getCreatePromoCodeRequest();
        PromoCodeDto promoCodeDto = getPromoCodeDtoList().get(0);
        PromoCode promoCode = getPromoCodeList().get(0);
        User user = getUserList().get(0);

        when(userService.getUserByMail("test")).thenReturn(user);
        when(promoCodeRepository.save(promoCode)).thenReturn(promoCode);
        promoCode.setPublicId("test");

        PromoCodeDto response = promoCodeService.save(request);
        response.setPublicId("test");

        assertEquals(response,promoCodeDto);
        verify(userService).getUserByMail("test");
        verify(promoCodeRepository).save(promoCode);
    }*/

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


    //TODO toDto yu yaz
}