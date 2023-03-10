package com.example.etrade.service;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.dto.request.ProductPriceRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.model.Product;
import com.example.etrade.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public ProductDto save(CreateProductRequest request){
        var saved = productConverter.toEntity(request);
        productRepository.save(saved);
        return productConverter.convert(saved);
    }

    public void deleteByProductId(String productId){
        productRepository.deleteProductByProductId(productId);
    }

    public ProductDto getByProductId(String productId){
        var fromDbProduct = productRepository.findProductByProductId(productId)
                .orElseThrow(() -> new NotFoundException("ProductId not found: " + productId));
        return productConverter.convert(fromDbProduct);

    }

    protected Product getProductObjectByProductId(String productId){
        return productRepository.findProductByProductId(productId)
                .orElseThrow(() -> new NotFoundException(""));

    }

    protected void updateProduct(Product product){
        productRepository.save(product);
    }

    public void updateProductPrice(ProductPriceRequest request){
        Optional<Product> product = productRepository.findProductByProductId(request.getProductId());

        if (product.isPresent()){
            product.get().setProductPrice(request.getNewPrice());
            productRepository.save(product.get());
        }
    }

}