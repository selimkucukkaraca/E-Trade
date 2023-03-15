package com.example.etrade.service;

import com.example.etrade.dto.AddressDto;
import com.example.etrade.dto.request.ConfirmCartRequest;
import com.example.etrade.model.Address;
import com.example.etrade.model.ConfirmedCart;
import org.springframework.stereotype.Service;

@Service
public class BuyProductService {

    private final BankAccountService bankAccountService;
    private final ConfirmedCardService confirmedCardService;
    private final CartService cartService;
    private final UserService userService;
    private final AddressService addressService;

    public BuyProductService(BankAccountService bankAccountService,
                             ConfirmedCardService confirmedCardService,
                             CartService cartService, UserService userService,
                             AddressService addressService) {
        this.bankAccountService = bankAccountService;
        this.confirmedCardService = confirmedCardService;
        this.cartService = cartService;
        this.userService = userService;
        this.addressService = addressService;
    }

    public void buy(ConfirmCartRequest confirmCartRequest){
        var cart = cartService.getCart(confirmCartRequest.getCartId());
        var bankAccount = bankAccountService.getByCardNumber(confirmCartRequest.getCardNumber());
        var user = userService.getUserByMail(confirmCartRequest.getUserMail());

        if (bankAccountService.validateCreditCard(confirmCartRequest)) {
            cart.getProduct()
                    .forEach((product) -> {
                        if (bankAccount.getBalance() >= product.getProductPrice()) {
                            bankAccount.setBalance(bankAccount.getBalance() - product.getProductPrice());
                            cartService.deleteByCartId(confirmCartRequest.getCartId());
                            Address address = addressService.save(confirmCartRequest.getAddress());
                            user.getAddress().add(address);
                        }
                    });

            ConfirmedCart confirmedCart = new ConfirmedCart(cart, user);
            confirmedCardService.save(confirmedCart);
            bankAccountService.save(bankAccount);
        }
    }
}