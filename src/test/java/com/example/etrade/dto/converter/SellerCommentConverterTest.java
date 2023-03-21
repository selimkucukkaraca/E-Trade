package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.SellerCommentDto;
import com.example.etrade.dto.SellerDto;
import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.request.CreateSellerCommentRequest;
import com.example.etrade.model.Seller;
import com.example.etrade.model.SellerComment;
import com.example.etrade.model.User;
import com.example.etrade.service.SellerService;
import com.example.etrade.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SellerCommentConverterTest extends TestUtil {

    private SellerConverter sellerConverter;
    private SellerService sellerService;
    private UserConverter userConverter;
    private UserService userService;
    private SellerCommentConverter sellerCommentConverter;

    @BeforeEach
    public void setUp(){
        sellerConverter = mock(SellerConverter.class);
        sellerService = mock(SellerService.class);
        userConverter = mock(UserConverter.class);
        userService = mock(UserService.class);
        sellerCommentConverter = mock(SellerCommentConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnSellerCommentDto(){
        SellerCommentDto sellerCommentDto = getSellerCommentDtoList().get(0);
        SellerComment sellerComment = getSellerCommentList().get(0);
        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);

        when(sellerCommentConverter.convertToDto(sellerComment)).thenReturn(sellerCommentDto);
        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);
        when(userConverter.convertToDto(user)).thenReturn(userDto);

        SellerCommentDto response = sellerCommentConverter.convertToDto(sellerComment);

        assertEquals(sellerCommentDto,response);
    }

    @Test
    public void toEntity_itShouldReturnSellerComment(){
        CreateSellerCommentRequest request = getCreateSellerCommentRequest();
        SellerComment sellerComment = getSellerCommentList().get(0);
        Seller seller = getSellerList().get(0);
        User user = getUserList().get(0);

        when(sellerCommentConverter.toEntity(request)).thenReturn(sellerComment);
        when(sellerService.getSellerByMail("test")).thenReturn(seller);
        when(userService.getUserByMail("test")).thenReturn(user);

        SellerComment response = sellerCommentConverter.toEntity(request);

        assertEquals(sellerComment,response);

    }
}