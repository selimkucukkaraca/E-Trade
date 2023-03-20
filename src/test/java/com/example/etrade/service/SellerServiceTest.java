package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.SellerDto;
import com.example.etrade.dto.converter.SellerConverter;
import com.example.etrade.dto.request.CreateSellerRequest;
import com.example.etrade.model.Seller;
import com.example.etrade.repository.ConfirmCodeRepository;
import com.example.etrade.repository.SellerRepository;
import com.example.etrade.util.MailSendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SellerServiceTest extends TestUtil {

    private MailSendService mailSendService;
    private ConfirmCodeService confirmCodeService;
    private ConfirmCodeRepository confirmCodeRepository;
    private SellerConverter sellerConverter;
    private SellerRepository sellerRepository;
    private SellerService sellerService;

    @BeforeEach
    public void setUp(){
        mailSendService = mock(MailSendService.class);
        confirmCodeService = mock(ConfirmCodeService.class);
        confirmCodeRepository = mock(ConfirmCodeRepository.class);
        sellerConverter = mock(SellerConverter.class);
        sellerRepository = mock(SellerRepository.class);
        sellerService = new SellerService(mailSendService,confirmCodeService,confirmCodeRepository,sellerConverter,sellerRepository);
    }

    @Test
    public void saveSeller_itShouldReturnSellerDto(){

        CreateSellerRequest request = getCreateSellerRequest();
        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);

        when(sellerConverter.toEntity(request)).thenReturn(seller);
        when(sellerRepository.existsSellerByMail("test")).thenReturn(false);
        when(sellerRepository.save(seller)).thenReturn(seller);
        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);

        SellerDto response = sellerService.save(request);

        assertEquals(response,sellerDto);

        verify(sellerConverter).toEntity(request);
        verify(sellerRepository.existsSellerByMail("test"));
        verify(sellerRepository).save(seller);
        verify(sellerConverter).convertToDto(seller);
    }

    @Test
    public void getByMail_itShouldReturnSellerDto(){
        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);
        String mail = "test";

        when(sellerRepository.findSellerByMail(mail)).thenReturn(Optional.ofNullable(seller));
        assert seller != null;
        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);

        SellerDto response = sellerService.getByMail(mail);

        assertEquals(response,sellerDto);
        verify(sellerRepository).findSellerByMail(mail);
        verify(sellerConverter).convertToDto(seller);
    }

    @Test
    public void getSellerByMail_itShouldReturnSeller(){

        Seller seller = getSellerList().get(0);
        String mail = "test";

        when(sellerRepository.findSellerByMail(mail)).thenReturn(Optional.ofNullable(seller));

        Seller response = sellerService.getSellerByMail(mail);

        assertEquals(response,seller);
        verify(sellerRepository).findSellerByMail(mail);
    }

    @Test
    public void delete(){
        Seller seller = getSellerList().get(0);
        String mail = "test";

        when(sellerRepository.findSellerByMail(mail)).thenReturn(Optional.ofNullable(seller));

        sellerService.delete(mail);

        assert seller != null;
        verify(sellerRepository).delete(seller);
    }

    //TODO sendConfirmCode,active,deActive
}