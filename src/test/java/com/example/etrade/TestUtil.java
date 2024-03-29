package com.example.etrade;

import com.example.etrade.dto.*;
import com.example.etrade.dto.request.*;
import com.example.etrade.model.*;

import java.time.LocalDate;
import java.util.List;

public class TestUtil {

    public CreateUserRequest getCreateUserRequest() {
        return new CreateUserRequest("test", "test", "test", "test");
    }

    public List<UserDto> getUserDtoList() {
        return List.of(new UserDto("test", "test", "test", true));
    }

    public List<User> getUserList() {
        return List.of(new User(1L, "test", "test", "test", "test", true, null, List.of(new Address(
                "test",
                "test",
                "test",
                "test",
                "test"
        ))));
    }


    public CreateSellerRequest getCreateSellerRequest() {
        return new CreateSellerRequest("test", "test", "test", "test");
    }

    public List<SellerDto> getSellerDtoList() {
        return List.of(new SellerDto("test", "test", "test", true));
    }

    public List<Seller> getSellerList() {
        return List.of(new Seller(1L, "test", "test", "test", "test", true, null));
    }


    public CreateCategoryRequest getCreateCategoryRequest() {
        CreateCategoryRequest request = new CreateCategoryRequest();
        request.setCategoryName("test");
        return request;
    }

    public List<CategoryDto> getCategoryDtoList() {
        return List.of(new CategoryDto("test"));
    }

    public List<Category> getCategoryList() {
        return List.of(new Category(1L, "test", null));
    }


    public CreateAddressRequest getCreateAddressRequest() {
        return new CreateAddressRequest("test", "test", "test", "test", "test");
    }

    public List<AddressDto> getAddressDtoList() {
        return List.of(new AddressDto("test", "test", "test", "test", "test"));
    }

    public List<Address> getAddressList() {
        return List.of(new Address("test", "test", "test", "test", "test"));
    }


    public CreateBrandRequest getCreateBrandRequest() {
        CreateBrandRequest request = new CreateBrandRequest();
        request.setBrand("test");
        return request;
    }

    public List<BrandDto> getBrandDtoList() {
        return List.of(new BrandDto("test", "test"));
    }

    public List<Brand> getBrandList() {
        return List.of(new Brand(1L, "test", "test"));
    }


    public CreateSubCategoryRequest getCreateSubCategoryRequest() {
        return new CreateSubCategoryRequest("test", "test");
    }

    public List<SubCategoryDto> getSubCategoryDtoList() {
        return List.of(new SubCategoryDto("test"));
    }

    public List<SubCategory> getSubCategoryList() {
        return List.of(new SubCategory(1L, "test"));
    }


    public CreateSellerCommentRequest getCreateSellerCommentRequest() {
        return new CreateSellerCommentRequest("test", "test", 1, "test", "test");
    }

    public List<SellerCommentDto> getSellerCommentDtoList() {
        return List.of(new SellerCommentDto("test", "test", 1, null, null));
    }

    public List<SellerComment> getSellerCommentList() {
        return List.of(new SellerComment(1L, "test", "test", 1, null, null, "test"));
    }


    public CreatePromoCodeRequest getCreatePromoCodeRequest() {
        return new CreatePromoCodeRequest("test", "test", 1L, LocalDate.now());
    }

    public List<PromoCodeDto> getPromoCodeDtoList() {
        return List.of(new PromoCodeDto("test", "test", 1L, "test1.0", null, null));
    }

    public List<PromoCode> getPromoCodeList() {
        return List.of(new PromoCode("test", "test", 1L, null, null));
    }


    public CreateProductRequest getCreateProductRequest() {
        return new CreateProductRequest("test", "test", 1L, 0, "test", "test", "test");
    }

    public List<ProductDto> getProductDtoList() {
        return List.of(new ProductDto("test", "test", 1L, 0, "test", "test", null));
    }

    public List<Product> getProductList() {
        return List.of(new Product(1L, "test", "test", 1L, 0, "test", null, null, "test", null));
    }


    public CreateProductCommentRequest getCreateProductCommentRequest() {
        return new CreateProductCommentRequest("test", "test", 0, "test", "test");
    }

    public List<ProductCommentDto> getProductCommentDtoList() {
        return List.of(new ProductCommentDto("test", "test", 0, null, null));
    }

    public List<ProductComment> getProductCommentList() {
        return List.of(new ProductComment(1L, "test", "test", 0, null, "test", null));
    }


    public List<ConfirmedCartDto> getConfirmedCartDtoList() {
        return List.of(new ConfirmedCartDto(null, "test"));
    }

    public List<ConfirmedCart> getConfirmedCartList() {
        return List.of(new ConfirmedCart(null, null));
    }


    public List<ConfirmCode> getConfirmCodeList() {
        return List.of(new ConfirmCode(1L, 0));
    }


    public List<BankAccount> getBankAccountList() {
        return List.of(new BankAccount(1L, "test", "test", 0, "test", 1L));
    }


    public List<CartDto> getCartDtoList() {
        return List.of(new CartDto(null, null, "test"));
    }

    public List<Cart> getCartList(Product product, User user) {
        return List.of(new Cart(1L, null, null, "test"));
    }

}