package com.example.etrade.service;

import com.example.etrade.dto.SellerCommentDto;
import com.example.etrade.dto.converter.SellerCommentConverter;
import com.example.etrade.dto.request.CreateSellerCommentRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.exception.generic.GenericExistException;
import com.example.etrade.repository.SellerCommentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SellerCommentService {

    private final SellerCommentRepository sellerCommentRepository;
    private final SellerCommentConverter sellerCommentConverter;

    public SellerCommentService(SellerCommentRepository sellerCommentRepository,
                                SellerCommentConverter sellerCommentConverter) {
        this.sellerCommentRepository = sellerCommentRepository;
        this.sellerCommentConverter = sellerCommentConverter;
    }

    @CachePut(value = "sellerComments", key = "#request")
    public SellerCommentDto save(CreateSellerCommentRequest request) {
        var saved = sellerCommentConverter.toEntity(request);
        if (request.getStar() < 0) {
            throw new GenericExistException("you must rating by star ");
        }
        sellerCommentRepository.save(saved);
        return sellerCommentConverter.convertToDto(saved);
    }

    @CacheEvict(value = "sellerComments", key = "#sellerCommentId")
    public void delete(String sellerCommentId) {
        var fromSellerComment = sellerCommentRepository
                .findSellerCommentBySellerCommentId(sellerCommentId);
        sellerCommentRepository.delete(fromSellerComment.get());
    }

    @Cacheable(value = "sellerComments", key = "#sellerCommentId")
    public SellerCommentDto getSellerBySellerCommentId(String sellerCommentId) {
        var sellerComment = sellerCommentRepository.findSellerCommentBySellerCommentId(sellerCommentId)
                .orElseThrow(() -> new NotFoundException(""));
        return sellerCommentConverter.convertToDto(sellerComment);
    }
}