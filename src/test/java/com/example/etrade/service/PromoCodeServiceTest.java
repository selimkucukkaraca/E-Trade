package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.model.PromoCode;
import com.example.etrade.model.User;
import com.example.etrade.repository.PromoCodeRepository;
import com.example.etrade.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PromoCodeServiceTest extends TestUtil {

    private PromoCodeRepository promoCodeRepository;
    private UserService userService;
    private PromoCodeService promoCodeService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        promoCodeRepository = mock(PromoCodeRepository.class);
        userService = mock(UserService.class);
        userRepository = mock(UserRepository.class);
        promoCodeService = new PromoCodeService(promoCodeRepository, userService);
    }

    @Test
    public void savePromoCode_itShouldReturnPromoCodeDto() {

        PromoCode promoCode = getPromoCodeList().get(0);
        User user = getUserList().get(0);

        when(userRepository.findUserByMail(user.getMail())).thenReturn(Optional.of(user));
        when(userService.getUserByMail(user.getMail())).thenReturn(user);

    }

    @Test
    public void getByCodeText_itShouldReturnPromoCode() {

        PromoCode promoCode = getPromoCodeList().get(0);

        when(promoCodeRepository.findPromoCodeByCodeText("test")).thenReturn(Optional.ofNullable(promoCode));

        PromoCode response = promoCodeService.getByCodeText("test");

        assertEquals(response, promoCode);
        verify(promoCodeRepository).findPromoCodeByCodeText("test");

    }

    @Test
    public void getByPublicId_itShouldReturnByPublicId() {

        PromoCode promoCode = getPromoCodeList().get(0);

        when(promoCodeRepository.findPromoCodeByPublicId("test")).thenReturn(Optional.ofNullable(promoCode));

        PromoCode response = promoCodeService.getByPublicId("test");

        assertEquals(response, promoCode);
        verify(promoCodeRepository).findPromoCodeByPublicId("test");

    }

    @Test
    public void delete() {

        PromoCode promoCode = getPromoCodeList().get(0);
        String publicId = "test";

        when(promoCodeRepository.findPromoCodeByPublicId(publicId)).thenReturn(Optional.ofNullable(promoCode));

        promoCodeService.delete(publicId);

        assert promoCode != null;
        verify(promoCodeRepository).delete(promoCode);

    }
}