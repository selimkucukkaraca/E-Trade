package com.example.etrade.service;

import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.converter.ProductCommentConverter;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.exception.generic.GenericExistException;
import com.example.etrade.repository.ProductCommentRepository;
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

    public ProductCommentDto save(CreateProductCommentRequest request){
        var saved = productCommentConverter.toEntity(request);
        if (request.getStar() < 0){
            throw new GenericExistException("you must rating by star ");
        }
        productCommentRepository.save(saved);
        return productCommentConverter.convert(saved);
    }

    public void delete(String productCommentId){
        productCommentRepository.deleteByProductCommentId(productCommentId);
    }

    public ProductCommentDto getProductCommentByProductCommentId(String productCommentId){
        var productComment = productCommentRepository
                .findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new NotFoundException(""));
        return productCommentConverter.convert(productComment);
    }

}