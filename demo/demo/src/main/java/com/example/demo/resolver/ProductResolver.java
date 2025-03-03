package com.example.demo.resolver;

import com.example.demo.entity.product.Clothing;
import com.example.demo.entity.product.Electronics;
import com.example.demo.entity.product.Product;
import com.example.demo.input.AddProductInput;
import com.example.demo.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductResolver {
    private final ProductService productService;

    public ProductResolver(ProductService productService) {
        this.productService = productService;
    }
    @QueryMapping
    List<Product> getProducts(){
        return productService.getProducts();
    }

    @MutationMapping
    Product addProduct(@Argument AddProductInput addProductInput) throws BadRequestException {
        return productService.addProduct(addProductInput);
    }

    @SubscriptionMapping
    public Flux<Product> newProduct(@Argument String productName) {
        return productService.messageFlux(productName);
    }

}
