package com.example.demo.service;

import com.example.demo.entity.product.Product;
import com.example.demo.repository.Database;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final Database database;

    public ProductService(Database database) {
        this.database = database;
    }

    public Product getProduct(String productId) throws BadRequestException {
        return database.products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Product not found"));
    }


}
