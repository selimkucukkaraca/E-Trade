package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.model.Product;
import com.example.etrade.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest extends TestUtil {

    private ProductRepository productRepository;
    private ProductConverter productConverter;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productConverter = mock(ProductConverter.class);
        productService = new ProductService(productRepository, productConverter);
    }

    @Test
    public void saveProduct_itShouldReturnProductDto() {

        CreateProductRequest request = getCreateProductRequest();
        Product product = getProductList().get(0);
        ProductDto productDto = getProductDtoList().get(0);

        when(productConverter.toEntity(request)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productConverter.convertToDto(product)).thenReturn(productDto);

        ProductDto response = productService.save(request);

        assertEquals(response, productDto);
        verify(productConverter).toEntity(request);
        verify(productRepository).save(product);
        verify(productConverter).convertToDto(product);

    }

    @Test
    public void getByProductId_itShouldReturnProductDto() {

        Product product = getProductList().get(0);
        ProductDto productDto = getProductDtoList().get(0);
        String productId = "test";

        when(productRepository.findProductByProductId(productId)).thenReturn(Optional.ofNullable(product));
        assert product != null;
        when(productConverter.convertToDto(product)).thenReturn(productDto);

        ProductDto response = productService.getByProductId(productId);

        assertEquals(response, productDto);
        verify(productRepository).findProductByProductId(productId);
        verify(productConverter).convertToDto(product);

    }

    @Test
    public void getProductObjectByProductId_itShouldReturnProduct() {

        Product product = getProductList().get(0);
        String productId = "test";

        when(productRepository.findProductByProductId(productId)).thenReturn(Optional.ofNullable(product));

        Product response = productService.getProductObjectByProductId(productId);

        assertEquals(response, product);
        verify(productRepository).findProductByProductId(productId);

    }

    @Test
    public void updateProduct() {

        Product product = getProductList().get(0);

        when(productRepository.save(product)).thenReturn(product);

        productService.updateProduct(product);

        verify(productRepository).save(product);

    }

    @Test
    public void delete() {

        Product product = getProductList().get(0);
        String productId = "test";

        when(productRepository.findProductByProductId(productId)).thenReturn(Optional.ofNullable(product));

        productService.deleteByProductId(productId);

        assert product != null;
        verify(productRepository).delete(product);

    }
}