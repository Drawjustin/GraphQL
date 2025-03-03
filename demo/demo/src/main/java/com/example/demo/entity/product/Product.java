package com.example.demo.entity.product;

import com.example.demo.entity.SearchResult;

public interface Product extends SearchResult {
    String getId();
    String getName();
    Double getPrice();
    ProductType getProductType();
}
