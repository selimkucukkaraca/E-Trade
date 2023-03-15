package com.example.etrade.dto.converter;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.model.Brand;
import com.example.etrade.model.Category;
import com.example.etrade.model.Product;
import com.example.etrade.service.BrandService;
import com.example.etrade.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final BrandConverter brandConverter;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public ProductConverter(BrandConverter brandConverter,
                            BrandService brandService,
                            CategoryService categoryService) {
        this.brandConverter = brandConverter;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    public ProductDto convertToDto(Product from){
        return new ProductDto(
                from.getProductName(),
                from.getProductDetails(),
                from.getProductPrice(),
                from.getStock(),
                from.getProductImageUrl(),
                from.getProductId(),
                brandConverter.convertToDto(from.getBrand())
        );
    }

    public Product toEntity(CreateProductRequest request){
        return new Product(
                request.getProductName(),
                request.getProductDetails(),
                request.getProductPrice(),
                request.getStock(),
                request.getProductImageUrl(),
                categoryService.getByCategoryName(request.getCategoryName()),
                brandService.getBrandByBrand(request.getBrand())
        );
    }
}