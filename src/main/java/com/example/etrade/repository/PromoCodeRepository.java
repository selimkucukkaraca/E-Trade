package com.example.etrade.repository;

import com.example.etrade.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {

    Optional<PromoCode> findPromoCodeByPublicId(String publicId);

    Optional<PromoCode> findPromoCodeByCodeText(String codeText);

}