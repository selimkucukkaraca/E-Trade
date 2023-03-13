package com.example.etrade;

import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.request.CreateUserRequest;
import com.example.etrade.model.User;

import java.util.List;

public class TestUtil {

    public CreateUserRequest getCreateUserRequest(){
        return new CreateUserRequest("test","test","test","test");
    }

    public List<UserDto> getUserDtoList(){
        return List.of(new UserDto("test","test","test",true));
    }

    public List<User> getUserList(){
        return List.of(new User(1L,"test","test","test","test",true,null,null));

    }

}
