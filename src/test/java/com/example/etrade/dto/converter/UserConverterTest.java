package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.request.CreateUserRequest;
import com.example.etrade.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserConverterTest extends TestUtil {

    private UserConverter userConverter;

    @BeforeEach
    public void setUp() {
        userConverter = mock(UserConverter.class);
    }

    @Test
    public void  convertToDto_itShouldReturnUserDto() {
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);

        when(userConverter.convertToDto(user)).thenReturn(userDto);

        UserDto response = userConverter.convertToDto(user);

        assertEquals(userDto,response);
    }

    @Test
    public void toEntity_itShouldReturnUser() {
        CreateUserRequest request = getCreateUserRequest();
        User user = getUserList().get(0);

        when(userConverter.toEntity(request)).thenReturn(user);

        User response = userConverter.toEntity(request);

        assertEquals(user,response);
    }
}