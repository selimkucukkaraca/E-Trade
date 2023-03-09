package com.example.etrade.dto.converter;

import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.model.ProductComment;
import org.springframework.stereotype.Component;

@Component
public class ProductCommentConverter {

    public ProductCommentDto convert(ProductComment from){
        return new ProductCommentDto(
                from.getTitle(),
                from.getBody(),
                from.getStar()
        );
    }

    public ProductComment toEntity(CreateProductCommentRequest request){
        return new ProductComment(
                request.getTitle(),
                request.getBody(),
                request.getStar()
        );
    }
}