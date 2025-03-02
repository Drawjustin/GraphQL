package com.example.demo.service;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.user.User;
import com.example.demo.input.AddUserInput;
import com.example.demo.repository.Database;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class UserService {
    private final Database database;
    private final CartService cartService;

    public UserService(Database database, CartService cartService) {
        this.database = database;
        this.cartService = cartService;
    }

    public User getUser(String userId) throws BadRequestException {
        return database.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .map(user -> {
                    try {
                        user.setCart(cartService.getUserCart(userId));
                        return user;
                    } catch (BadRequestException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new BadRequestException("User not found"));

    }

    public User addUser(AddUserInput addUserInput) {
        User user = new User(
                UUID.randomUUID().toString().substring(0, 5),
                addUserInput.getName(),
                addUserInput.getEmail(),
                OffsetDateTime.now()
        );
        database.users.add(user);
        user.setCart(cartService.addUserCart(user));
        return user;
    }
}
