package com.example.etrade;

import com.example.etrade.dto.*;
import com.example.etrade.dto.request.*;
import com.example.etrade.model.*;

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



    public CreateCategoryRequest getCreateCategoryRequest(){
        return new CreateCategoryRequest("test");
    }

    public List<CategoryDto> getCategoryDtoList(){
        return List.of(new CategoryDto("test",null));
    }

    public List<Category> getCategoryList(){
        return List.of(new Category(1L,"test",null));
    }



    public CreateAddressRequest getCreateAddressRequest(){
        return new CreateAddressRequest("test","test","test","test","test");
    }

    public List<AddressDto> getAddressDtoList(){
        return List.of(new AddressDto("test","test","test","test","test"));
    }

    public List<Address> getAddressList(){
        return List.of(new Address("test","test","test","test","test"));
    }



    public CreateBrandRequest getCreateBrandRequest(){
        return new CreateBrandRequest("test");
    }

    public List<BrandDto> getBrandDtoList(){
        return List.of(new BrandDto("test","test"));
    }

    public List<Brand> getBrandList(){
        return List.of(new Brand(1L,"test","test"));
    }


}
