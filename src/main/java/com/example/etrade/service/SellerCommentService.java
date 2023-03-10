package com.example.etrade.service;

import com.example.etrade.dto.SellerCommentDto;
import com.example.etrade.dto.converter.SellerCommentConverter;
import com.example.etrade.dto.request.CreateSellerCommentRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.exception.generic.GenericExistException;
import com.example.etrade.repository.SellerCommentRepository;
import org.springframework.stereotype.Service;


@Service
public class SellerCommentService {

    private final SellerCommentRepository sellerCommentRepository;
    private final SellerService sellerService;
    private final SellerCommentConverter sellerCommentConverter;

    public SellerCommentService(SellerCommentRepository sellerCommentRepository,
                                SellerService sellerService, SellerCommentConverter sellerCommentConverter) {
        this.sellerCommentRepository = sellerCommentRepository;
        this.sellerService = sellerService;
        this.sellerCommentConverter = sellerCommentConverter;
    }

    public SellerCommentDto save(CreateSellerCommentRequest request){
        var saved = sellerCommentConverter.toEntity(request);
        if (request.getStar() < 0){
            throw new GenericExistException("you must rating by star ");
        }
        sellerCommentRepository.save(saved);
        return sellerCommentConverter.convert(saved);
    }

    public void delete(String sellerCommentId) {
        var fromSellerComment = sellerCommentRepository
                .findSellerCommentBySellerCommentId(sellerCommentId);
        sellerCommentRepository.delete(fromSellerComment.get());
    }

    public SellerCommentDto getSellerBySellerCommentId(String sellerCommentId){
        var sellerComment = sellerCommentRepository.findSellerCommentBySellerCommentId(sellerCommentId)
                .orElseThrow(() -> new NotFoundException(""));
        return sellerCommentConverter.convert(sellerComment);
    }

}