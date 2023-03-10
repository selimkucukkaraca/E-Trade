package com.example.etrade.service;

import com.example.etrade.dto.request.CreditCardRequest;
import com.example.etrade.model.ConfirmedCart;
import org.springframework.stereotype.Service;

@Service
public class BuyProductService {

    private final BankAccountService bankAccountService;
    private final ConfirmedCardService confirmedCardService;
    private final CartService cartService;
    private final UserService userService;

    public BuyProductService(BankAccountService bankAccountService,
                             ConfirmedCardService confirmedCardService,
                             CartService cartService, UserService userService) {
        this.bankAccountService = bankAccountService;
        this.confirmedCardService = confirmedCardService;
        this.cartService = cartService;
        this.userService = userService;
    }

    public void buy(CreditCardRequest creditCardRequest, String cartId, String userMail){ //TODO promo code
        var cart = cartService.getCart(cartId);
        var bankAccount = bankAccountService.getByCardNumber(creditCardRequest.getCardNumber());
        var user = userService.getUserByMail(userMail);

        if (bankAccountService.validateCreditCard(creditCardRequest)) {
            cart.getProduct()
                    .forEach((product) -> {
                        if (bankAccount.getBalance() >= product.getProductPrice()) {
                            bankAccount.setBalance(bankAccount.getBalance() - product.getProductPrice());
                            cartService.deleteByCartId(cartId);
                        }
                    });

            ConfirmedCart confirmedCart = new ConfirmedCart(cart, user);
            confirmedCardService.save(confirmedCart);
            bankAccountService.save(bankAccount);
        }
    }
}
