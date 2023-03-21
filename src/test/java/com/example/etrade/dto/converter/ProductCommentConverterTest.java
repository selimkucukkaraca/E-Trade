package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.model.Product;
import com.example.etrade.model.ProductComment;
import com.example.etrade.model.User;
import com.example.etrade.service.ProductService;
import com.example.etrade.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductCommentConverterTest extends TestUtil {

    private UserConverter userConverter;
    private UserService userService;
    private ProductConverter productConverter;
    private ProductService productService;
    private ProductCommentConverter productCommentConverter;

    @BeforeEach
    public void setUp(){
        userConverter = mock(UserConverter.class);
        userService = mock(UserService.class);
        productConverter = mock(ProductConverter.class);
        productService = mock(ProductService.class);
        productCommentConverter = mock(ProductCommentConverter.class);
    }

   @Test
    public void convertToDto_itShouldReturnProductCommentDto(){
        ProductComment productComment = getProductCommentList().get(0);
        ProductCommentDto productCommentDto = getProductCommentDtoList().get(0);
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);
        Product product = getProductList().get(0);
        ProductDto productDto = getProductDtoList().get(0);

        when(productCommentConverter.convertToDto(productComment)).thenReturn(productCommentDto);
        when(userConverter.convertToDto(user)).thenReturn(userDto);
        when(productConverter.convertToDto(product)).thenReturn(productDto);

        ProductCommentDto response = productCommentConverter.convertToDto(productComment);

        assertEquals(productCommentDto,response);
    }

    @Test
    public void toEntity_itShouldReturnProductComment(){
        CreateProductCommentRequest request = getCreateProductCommentRequest();
        ProductComment productComment = getProductCommentList().get(0);
        User user = getUserList().get(0);
        Product product = getProductList().get(0);

        when(productCommentConverter.toEntity(request)).thenReturn(productComment);
        when(userService.getUserByMail("test")).thenReturn(user);
        when(productService.getProductObjectByProductId("test")).thenReturn(product);

        ProductComment response = productCommentConverter.toEntity(request);

        assertEquals(productComment,response);
    }
}