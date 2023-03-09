package com.example.etrade.dto.converter;

import com.example.etrade.dto.SellerCommentDto;
import com.example.etrade.dto.request.CreateSellerCommentRequest;
import com.example.etrade.model.SellerComment;
import org.springframework.stereotype.Component;

@Component
public class SellerCommentConverter {

    public SellerCommentDto convert(SellerComment from){
        return new SellerCommentDto(
                from.getTitle(),
                from.getBody(),
                from.getStar()
        );
    }

    public SellerComment toEntity(CreateSellerCommentRequest request){
        return new SellerComment(
                request.getTitle(),
                request.getBody(),
                request.getStar()
        );
    }
}