package com.example.demo.repository;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.cart.CartItem;
import com.example.demo.entity.product.Clothing;
import com.example.demo.entity.product.Electronics;
import com.example.demo.entity.product.Product;
import com.example.demo.entity.user.User;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class Database {
    // products
    public List<Product> products = new ArrayList<>(Arrays.asList(
            new Electronics("1","mac book air", 1000.0, "3years"),
            new Electronics("2","1phone 19", 2000.0, "2years"),
            new Electronics("3","samsung tv", 3000.0, "1years"),
            new Clothing("4","T-shirt",300.0,"M"),
            new Clothing("5","Jeans",200.0,"L"),
            new Clothing("6","Dress",100.0,"S")
    ));

    // users
    public List<User> users = new ArrayList<>(Arrays.asList(
            new User("1","Burger","burgerGoopang.com", OffsetDateTime.now().minusDays(30)),
            new User("2","HJ","HJ.com", OffsetDateTime.now().minusDays(60))
    ));

    // carts
    public List<Cart> carts = new ArrayList<>(Arrays.asList(
            new Cart("1",users.get(0)),
            new Cart("2",users.get(1))
    ));

    // cartItems
    public List<CartItem> cartItems = new ArrayList<>(Arrays.asList(
            new CartItem("1", 1, products.get(0), carts.get(0)),
            new CartItem("2", 3, products.get(2), carts.get(0)),
            new CartItem("3", 2, products.get(4), carts.get(0)),
            new CartItem("4", 1, products.get(5), carts.get(1)),
            new CartItem("5", 2, products.get(1), carts.get(1))
    ));



}
