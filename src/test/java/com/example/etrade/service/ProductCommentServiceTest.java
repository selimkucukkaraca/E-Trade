package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.converter.ProductCommentConverter;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.model.ProductComment;
import com.example.etrade.repository.ProductCommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductCommentServiceTest extends TestUtil {

    private ProductCommentRepository productCommentRepository;
    private ProductCommentConverter productCommentConverter;
    private ProductCommentService productCommentService;

    @BeforeEach
    public void setUp() {
        productCommentRepository = mock(ProductCommentRepository.class);
        productCommentConverter = mock(ProductCommentConverter.class);
        productCommentService = new ProductCommentService(productCommentRepository, productCommentConverter);
    }

    @Test
    public void saveProductComment_itShouldReturnProductCommentDto() {

        CreateProductCommentRequest createProductCommentRequest = getCreateProductCommentRequest();
        ProductComment productComment = getProductCommentList().get(0);
        ProductCommentDto productCommentDto = getProductCommentDtoList().get(0);

        when(productCommentConverter.toEntity(createProductCommentRequest)).thenReturn(productComment);
        when(productCommentRepository.save(productComment)).thenReturn(productComment);
        when(productCommentConverter.convertToDto(productComment)).thenReturn(productCommentDto);

        ProductCommentDto response = productCommentService.save(createProductCommentRequest);

        assertEquals(response, productCommentDto);
        verify(productCommentConverter).toEntity(createProductCommentRequest);
        verify(productCommentRepository).save(productComment);
        verify(productCommentConverter).convertToDto(productComment);

    }

    @Test
    public void delete() {

        ProductComment productComment = getProductCommentList().get(0);
        String productCommentId = "test";

        when(productCommentRepository.findProductCommentByProductCommentId(productCommentId)).thenReturn(Optional.ofNullable(productComment));

        productCommentService.delete(productCommentId);

        assert productComment != null;
        verify(productCommentRepository).delete(productComment);

    }

    @Test
    public void getProductCommentByProductCommentId_itShouldReturnProductComment() {

        ProductComment productComment = getProductCommentList().get(0);
        String productCommentId = "test";

        when(productCommentRepository.findProductCommentByProductCommentId(productCommentId)).thenReturn(Optional.ofNullable(productComment));

        ProductComment response = productCommentService.getProductCommentByProductCommentId(productCommentId);

        assertEquals(response, productComment);
        verify(productCommentRepository).findProductCommentByProductCommentId(productCommentId);

    }

    @Test
    public void getByProductCommentId_itShouldReturnProductCommentDto() {

        ProductComment productComment = getProductCommentList().get(0);
        ProductCommentDto productCommentDto = getProductCommentDtoList().get(0);
        String productCommentId = "test";

        when(productCommentRepository.findProductCommentByProductCommentId(productCommentId)).thenReturn(Optional.ofNullable(productComment));
        assert productComment != null;
        when(productCommentConverter.convertToDto(productComment)).thenReturn(productCommentDto);

        ProductCommentDto response = productCommentService.getByProductCommentId(productCommentId);
        assertEquals(productCommentDto, response);
        verify(productCommentRepository).findProductCommentByProductCommentId(productCommentId);
        verify(productCommentConverter).convertToDto(productComment);

    }

}