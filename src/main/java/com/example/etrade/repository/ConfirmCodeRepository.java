package com.example.etrade.repository;

import com.example.etrade.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode,Long> {
}
