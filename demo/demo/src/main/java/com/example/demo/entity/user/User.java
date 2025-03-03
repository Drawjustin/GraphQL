package com.example.demo.entity.user;

import com.example.demo.entity.SearchResult;
import com.example.demo.entity.cart.Cart;

import java.time.OffsetDateTime;

public class User implements SearchResult {
    private String id;
    private String name;
    private String email;
    private OffsetDateTime createdAt;

    public User(String id, String name, String email, OffsetDateTime createdAt, Cart cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.cart = cart;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Cart getCart() {
        return cart;
    }

    public User(String id, String name, String email, OffsetDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    private Cart cart;
}
