package com.example.etrade.service;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.model.Brand;
import com.example.etrade.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductListService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final BrandService brandService;

    public ProductListService(ProductRepository productRepository,
                              ProductConverter productConverter,
                              BrandService brandService) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.brandService = brandService;
    }

    @Cacheable(value = "productLists", key = "#productName")
    public List<ProductDto> getProductByProductName(String productName) {
        return productRepository.findProductByProductName(productName)
                .stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "productLists", key = "#min and #max")
    public List<ProductDto> getProductByProductPrice(double min, double max) {
        return productRepository.findAll()
                .stream()
                .filter((product) ->
                        product.getProductPrice() >= min && product.getProductPrice() <= max
                )
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "productLists", key = "#brand")
    public List<ProductDto> getProductByProductBrand(String brand) {
        Brand fromDbBrand = brandService.getBrandByBrand(brand);
        return productRepository.getProductByBrand(fromDbBrand)
                .stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

}