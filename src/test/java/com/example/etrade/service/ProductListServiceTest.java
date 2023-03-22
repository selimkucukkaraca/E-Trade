package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class ProductListServiceTest extends TestUtil {

    private ProductRepository productRepository;
    private ProductListService productListService;
    private ProductConverter productConverter;
    private BrandService brandService;

    @BeforeEach
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productConverter = mock(ProductConverter.class);
        brandService = mock(BrandService.class);
        productListService = new ProductListService(productRepository, productConverter, brandService);
    }

    //TODO 3 method

}