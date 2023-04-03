package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.converter.UserConverter;
import com.example.etrade.dto.request.CreateUserRequest;
import com.example.etrade.model.User;
import com.example.etrade.repository.UserRepository;
import com.example.etrade.util.MailSendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest extends TestUtil {

    private MailSendService mailSendService;
    private ConfirmCodeService confirmCodeService;
    private UserConverter userConverter;
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        mailSendService = mock(MailSendService.class);
        confirmCodeService = mock(ConfirmCodeService.class);
        userConverter = mock(UserConverter.class);
        userRepository = mock(UserRepository.class);
        userService = new UserService(mailSendService, confirmCodeService, userConverter, userRepository);
    }

    @Test
    public void saveUser_itShouldReturnUserDto() {

        CreateUserRequest request = getCreateUserRequest();
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);

        when(userConverter.toEntity(request)).thenReturn(user);
        when(userRepository.existsUserByMail("test")).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);
        when(userConverter.convertToDto(user)).thenReturn(userDto);

        UserDto response = userService.save(request);

        assertEquals(response, userDto);
        verify(userConverter).toEntity(request);
        verify(userRepository).existsUserByMail("test");
        verify(userRepository).save(user);
        verify(userConverter).convertToDto(user);

    }

    @Test
    public void delete() {

        User user = getUserList().get(0);
        String mail = "test";

        when(userRepository.findUserByMail(mail)).thenReturn(Optional.ofNullable(user));

        userService.delete(mail);

        assert user != null;
        verify(userRepository).delete(user);

    }

    @Test
    public void getByMail_itShouldReturnUserDto() {

        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);
        String mail = "test";

        when(userRepository.findUserByMail(mail)).thenReturn(Optional.ofNullable(user));
        assert user != null;
        when(userConverter.convertToDto(user)).thenReturn(userDto);

        UserDto response = userService.getByMail(mail);

        assertEquals(response, userDto);
        verify(userRepository).findUserByMail(mail);
        verify(userConverter).convertToDto(user);

    }

    @Test
    public void getUserByMail_itShouldReturnUser() {

        User user = getUserList().get(0);
        String mail = "test";

        when(userRepository.findUserByMail(mail)).thenReturn(Optional.ofNullable(user));

        User response = userService.getUserByMail(mail);

        assertEquals(response, user);
        verify(userRepository).findUserByMail(mail);

    }

    @Test
    public void deActiveUser_itShouldReturnUserDto() {
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);

        when(userRepository.save(user)).thenReturn(user);
        when(userConverter.convertToDto(user)).thenReturn(userDto);
        when(userRepository.findUserByMail("test")).thenReturn(Optional.of(user));

        UserDto response = userService.deActivateUser("test");

        assertEquals(userDto, response);
        verify(userRepository).save(user);
        verify(userConverter).convertToDto(user);
        verify(userRepository).findUserByMail("test");

    }

    @Test
    public void sendConfirmCode() {
    }

    @Test
    public void activeUser_itShouldReturnUserDto() {
    }

}