package com.example.demo.input;

import com.example.demo.entity.product.ProductType;

public class AddProductInput {
    private String name;
    private Double price;
    private ProductType productType;
    private String warrantyPeriod;
    private String size;

    public AddProductInput(String name, Double price, ProductType productType, String warrantyPeriod, String size) {
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.warrantyPeriod = warrantyPeriod;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
