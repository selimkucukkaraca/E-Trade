package com.example.etrade.dto.converter;

import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.request.CreateUserRequest;
import com.example.etrade.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto convert(User from){
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.getImageUrl(),
                from.isActive()
        );
    }

    public User toEntity(CreateUserRequest request){
        return new User(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                request.getImageUrl()
        );
    }
}