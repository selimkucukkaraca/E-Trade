package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.SellerCommentDto;
import com.example.etrade.dto.converter.SellerCommentConverter;
import com.example.etrade.dto.request.CreateSellerCommentRequest;
import com.example.etrade.model.SellerComment;
import com.example.etrade.repository.SellerCommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SellerCommentServiceTest extends TestUtil {

    private SellerCommentRepository sellerCommentRepository;
    private SellerCommentConverter sellerCommentConverter;
    private SellerCommentService sellerCommentService;

    @BeforeEach
    public void setUp() {
        sellerCommentRepository = mock(SellerCommentRepository.class);
        sellerCommentConverter = mock(SellerCommentConverter.class);
        sellerCommentService = new SellerCommentService(sellerCommentRepository, sellerCommentConverter);
    }

    @Test
    public void saveSellerComment_itShouldReturnSellerCommentDto() {

        CreateSellerCommentRequest request = getCreateSellerCommentRequest();
        SellerComment sellerComment = getSellerCommentList().get(0);
        SellerCommentDto sellerCommentDto = getSellerCommentDtoList().get(0);

        when(sellerCommentConverter.toEntity(request)).thenReturn(sellerComment);
        when(sellerCommentRepository.save(sellerComment)).thenReturn(sellerComment);
        when(sellerCommentConverter.convertToDto(sellerComment)).thenReturn(sellerCommentDto);

        SellerCommentDto response = sellerCommentService.save(request);

        assertEquals(response, sellerCommentDto);

        verify(sellerCommentConverter).toEntity(request);
        verify(sellerCommentRepository).save(sellerComment);
        verify(sellerCommentConverter).convertToDto(sellerComment);

    }

    @Test
    public void delete() {

        SellerComment sellerComment = getSellerCommentList().get(0);
        String sellerCommentId = "test";

        when(sellerCommentRepository.findSellerCommentBySellerCommentId(sellerCommentId)).thenReturn(Optional.ofNullable(sellerComment));

        sellerCommentService.delete(sellerCommentId);

        verify(sellerCommentRepository).findSellerCommentBySellerCommentId(sellerCommentId);

    }

    @Test
    public void getSellerBySellerCommentId_itShouldReturnSellerCommentDto() {

        SellerComment sellerComment = getSellerCommentList().get(0);
        SellerCommentDto sellerCommentDto = getSellerCommentDtoList().get(0);
        String sellerCommentId = "test";

        when(sellerCommentRepository.findSellerCommentBySellerCommentId(sellerCommentId)).thenReturn(Optional.ofNullable(sellerComment));
        assert sellerComment != null;
        when(sellerCommentConverter.convertToDto(sellerComment)).thenReturn(sellerCommentDto);

        SellerCommentDto response = sellerCommentService.getSellerBySellerCommentId(sellerCommentId);

        assertEquals(response, sellerCommentDto);
        verify(sellerCommentRepository).findSellerCommentBySellerCommentId(sellerCommentId);
        verify(sellerCommentConverter).convertToDto(sellerComment);

    }
}