package com.example.etrade;

import com.example.etrade.dto.SellerDto;
import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.request.CreateSellerRequest;
import com.example.etrade.dto.request.CreateUserRequest;
import com.example.etrade.model.Seller;
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


    public CreateSellerRequest getCreateSellerRequest(){
        return new CreateSellerRequest("test","test","test","test");
    }

    public List<SellerDto> getSellerDtoList(){
        return List.of(new SellerDto("test","test","test",true));
    }

    public List<Seller> getSellerList(){
        return List.of(new Seller(1L,"test","test","test","test",true,null));
    }



}
