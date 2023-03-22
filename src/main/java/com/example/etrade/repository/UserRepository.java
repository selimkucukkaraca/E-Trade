package com.example.etrade.repository;

import com.example.etrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByMail(String mail);

    boolean existsUserByMail(String mail);

}