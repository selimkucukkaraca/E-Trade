package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.BrandDto;
import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.model.Brand;
import com.example.etrade.model.Category;
import com.example.etrade.model.Product;
import com.example.etrade.service.BrandService;
import com.example.etrade.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductConverterTest extends TestUtil {

    private BrandConverter brandConverter;
    private BrandService brandService;
    private CategoryService categoryService;
    private ProductConverter productConverter;

    @BeforeEach
    public void setUp(){
        brandConverter = mock(BrandConverter.class);
        brandService = mock(BrandService.class);
        categoryService = mock(CategoryService.class);
        productConverter = mock(ProductConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnProductDto(){
        Product product = getProductList().get(0);
        ProductDto productDto = getProductDtoList().get(0);
        Brand brand = getBrandList().get(0);
        BrandDto brandDto = getBrandDtoList().get(0);

        when(productConverter.convertToDto(product)).thenReturn(productDto);
        when(brandConverter.convertToDto(brand)).thenReturn(brandDto);

        ProductDto response = productConverter.convertToDto(product);

        assertEquals(productDto,response);
    }

    @Test
    public void toEntity_itShouldReturnProduct(){
        CreateProductRequest request = getCreateProductRequest();
        Product product = getProductList().get(0);
        Brand brand = getBrandList().get(0);
        Category category = getCategoryList().get(0);

        when(productConverter.toEntity(request)).thenReturn(product);
        when(categoryService.getByCategoryName("test")).thenReturn(category);
        when(brandService.getBrandByBrand("test")).thenReturn(brand);

        Product response = productConverter.toEntity(request);

        assertEquals(product,response);

    }

}