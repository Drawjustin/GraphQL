package com.example.demo.entity.product;

public class Clothing implements Product{
    private String id;
    private String name;
    private Double price;
    private String size;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public Clothing(String id, String name, Double price, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public ProductType getProductType() {
        return ProductType.CLOTHING;
    }
}
