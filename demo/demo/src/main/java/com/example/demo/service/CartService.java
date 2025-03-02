package com.example.demo.service;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.cart.CartItem;
import com.example.demo.entity.user.User;
import com.example.demo.input.AddCartItemInput;
import com.example.demo.repository.Database;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {
    private final Database database;

    public CartService(Database database) {
        this.database = database;
    }
    public Cart addUserCart(User user) {
        Cart cart = new Cart(
                UUID.randomUUID().toString().substring(0, 5),
                user
        );
        database.carts.add(cart);
        return cart;
    }
    public Cart getUserCart(String userId) throws BadRequestException {
        return database.carts.stream()
                .filter(cart -> cart.getUser().getId().equals(userId))
                .findFirst()
                .map(cart -> {
                    cart.setItems(database.cartItems.stream()
                            .filter(cartItem -> cartItem.getCart().getId().equals(cart.getId()))
                            .toList());
                    cart.setTotalAmount(cart.getItems().stream()
                            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                            .sum());
                    return cart;
                })
                .orElseThrow(() -> new BadRequestException("Cart not found"));
    }

//    public Cart addCartItem(AddCartItemInput addCartItemInput) throws BadRequestException {
//        CartItem cartItem = new CartItem(
//                UUID.randomUUID().toString().substring(0, 5),
//                addCartItemInput.getQuantity(),
//                productService.getProduct(addCartItemInput.getProductId()),
//                getUserCart(addCartItemInput.getUserId())
//        );
//        Database.getInstance().cartItems.add(cartItem);
//        return getUserCart(addCartItemInput.getUserId());
//    }
//
//    public Cart deleteCartItem(DeleteCartItemInput deleteCartItemInput) throws BadRequestException {
//        Database.getInstance().cartItems.removeIf(cartItem -> cartItem.getId().equals(deleteCartItemInput.getCartItemId()));
//        return getUserCart(deleteCartItemInput.getUserId());
//    }
}
