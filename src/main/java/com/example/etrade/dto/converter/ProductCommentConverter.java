package com.example.etrade.dto.converter;

import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.model.ProductComment;
import com.example.etrade.service.ProductService;
import com.example.etrade.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ProductCommentConverter {

    private final UserConverter userConverter;
    private final UserService userService;
    private final ProductConverter productConverter;
    private final ProductService productService;

    public ProductCommentConverter(UserConverter userConverter, UserService userService,
                                   ProductConverter productConverter, ProductService productService) {
        this.userConverter = userConverter;
        this.userService = userService;
        this.productConverter = productConverter;
        this.productService = productService;
    }

    public ProductCommentDto convertToDto(ProductComment from){
        return new ProductCommentDto(
                from.getTitle(),
                from.getBody(),
                from.getStar(),
                userConverter.convertToDto(from.getUser()),
                productConverter.convertToDto(from.getProduct())
        );
    }

    public ProductComment toEntity(CreateProductCommentRequest request){
        return new ProductComment(
                request.getTitle(),
                request.getBody(),
                request.getStar(),
                userService.getUserByMail(request.getUserMail()),
                productService.getProductObjectByProductId(request.getProductId())
                );
    }
}