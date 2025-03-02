package com.example.demo.input;

public class AddCartItemInput {
    private String userId;
    private String productId;
    private int quantity;

    public AddCartItemInput(String userId, String productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
