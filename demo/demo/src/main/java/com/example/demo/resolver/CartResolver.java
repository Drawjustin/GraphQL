package com.example.demo.resolver;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.cart.CartItem;
import com.example.demo.input.AddCartItemInput;
import com.example.demo.input.DeleteCartItemInput;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class CartResolver {
    private final CartService cartService;

    public CartResolver(CartService cartService) {
        this.cartService = cartService;
    }

    @QueryMapping
    public Cart getUserCart(@Argument String userId) throws BadRequestException {
        return cartService.getUserCart(userId);
    }

    @MutationMapping
    public Cart addCartItem(@Argument AddCartItemInput addCartItemInput) throws BadRequestException {
        return cartService.addCartItem(addCartItemInput);
    }

    @MutationMapping
    public Cart deleteCartItem(@Argument DeleteCartItemInput deleteCartItemInput) throws BadRequestException {
        return cartService.deleteCartItem(deleteCartItemInput);
    }

}
