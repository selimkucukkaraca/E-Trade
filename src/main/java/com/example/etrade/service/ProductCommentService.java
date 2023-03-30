package com.example.etrade.service;

import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.converter.ProductCommentConverter;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.exception.generic.GenericExistException;
import com.example.etrade.model.ProductComment;
import com.example.etrade.repository.ProductCommentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentService {

    private final ProductCommentRepository productCommentRepository;
    private final ProductCommentConverter productCommentConverter;

    public ProductCommentService(ProductCommentRepository productCommentRepository,
                                 ProductCommentConverter productCommentConverter) {
        this.productCommentRepository = productCommentRepository;
        this.productCommentConverter = productCommentConverter;
    }

    @CachePut(value = "productComments", key = "#request")
    public ProductCommentDto save(CreateProductCommentRequest request) {
        var saved = productCommentConverter.toEntity(request);
        if (request.getStar() < 0) {
            throw new GenericExistException("you must rating by star ");
        }
        productCommentRepository.save(saved);
        return productCommentConverter.convertToDto(saved);
    }

    @CacheEvict(value = "productComments", key = "#productCommentId")
    public void delete(String productCommentId) {
        var productComment = getProductCommentByProductCommentId(productCommentId);
        productCommentRepository.delete(productComment);
    }

    @Cacheable(value = "productComments", key = "#productCommentId")
    public ProductComment getProductCommentByProductCommentId(String productCommentId) {
        return productCommentRepository.findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Cacheable(value = "productComments", key = "#productCommentId")
    public ProductCommentDto getByProductCommentId(String productCommentId) {
        var productComment = productCommentRepository
                .findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new NotFoundException(""));
        return productCommentConverter.convertToDto(productComment);
    }

}