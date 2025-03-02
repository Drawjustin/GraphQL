package com.example.demo.entity.cart;

import com.example.demo.entity.user.User;

import java.util.List;

public class Cart {
    private String id;
    private User user;

    private Double totalAmount;

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Cart(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public Cart(String id, User user, Double totalAmount) {
        this.id = id;
        this.user = user;
        this.totalAmount = totalAmount;
    }

    public Cart(String id, User user, Double totalAmount, List<CartItem> items) {
        this.id = id;
        this.user = user;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    private List<CartItem> items;
}
