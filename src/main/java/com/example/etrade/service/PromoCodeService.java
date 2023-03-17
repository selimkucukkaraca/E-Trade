package com.example.etrade.service;

import com.example.etrade.dto.PromoCodeDto;
import com.example.etrade.dto.request.CreatePromoCodeRequest;
import com.example.etrade.model.PromoCode;
import com.example.etrade.repository.PromoCodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    private final UserService userService;

    public PromoCodeService(PromoCodeRepository promoCodeRepository, UserService userService) {
        this.promoCodeRepository = promoCodeRepository;
        this.userService = userService;
    }

    public PromoCodeDto save(CreatePromoCodeRequest request) {
        PromoCode promoCode = new PromoCode(
                request.getCode(),
                request.getAmount(),
                request.getEndDate(),
                userService.getUserByMail(request.getUserMail())
        );

        String codeText = request.getCode() + String.valueOf(request.getAmount());
        promoCode.setCodeText(codeText);

        promoCodeRepository.save(promoCode);
        return toDto(promoCode);
    }

    public PromoCode getByPublicId(String publicId) {
        return promoCodeRepository.findPromoCodeByPublicId(publicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "promo code not found"));
    }

    public void delete(String publicId) {
        PromoCode fromDbCode = getByPublicId(publicId);
        promoCodeRepository.delete(fromDbCode);
    }

    public PromoCode getByCodeText(String codeText) {
        return promoCodeRepository.findPromoCodeByCodeText(codeText)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "promo code not found"));
    }

    private PromoCodeDto toDto(PromoCode from) {
        return new PromoCodeDto(
                from.getPublicId(),
                from.getCode(),
                from.getAmount(),
                from.getCodeText(),
                from.getEndDate(),
                userService.getByMail(from.getUser().getMail())
        );
    }
}
