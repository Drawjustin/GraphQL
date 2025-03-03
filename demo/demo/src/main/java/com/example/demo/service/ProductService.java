package com.example.demo.service;

import com.example.demo.entity.product.Clothing;
import com.example.demo.entity.product.Electronics;
import com.example.demo.entity.product.Product;
import com.example.demo.input.AddProductInput;
import com.example.demo.repository.Database;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final Database database;
    private final Sinks.Many<Product> productSink = Sinks.many()
            .multicast()
            .onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);

    public ProductService(Database database) {
        this.database = database;
    }

    public Product getProduct(String productId) throws BadRequestException {
        return database.products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Product not found"));
    }

    public List<Product> getProducts(){
        return database.products;
    }

    public Product addProduct(AddProductInput addProductInput) throws BadRequestException {
        Product product = switch(addProductInput.getProductType()){
            case ELECTRONICS -> {
                if(addProductInput.getWarrantyPeriod() == null){
                    throw new BadRequestException("Warranty period is required");
                }
                yield new Electronics(
                        UUID.randomUUID().toString().substring(0, 5),
                        addProductInput.getName(),
                        addProductInput.getPrice(),
                        addProductInput.getWarrantyPeriod()
                );
            }
            case CLOTHING -> {
                if(addProductInput.getSize() == null){
                    throw new BadRequestException("Size id required");
                }
                yield new Clothing(
                        UUID.randomUUID().toString().substring(0,5),
                        addProductInput.getName(),
                        addProductInput.getPrice(),
                        addProductInput.getSize()
                );
            }
        };
        database.products.add(product);
        productSink.tryEmitNext(product);
        return product;

    }


    public Flux<Product> messageFlux(String productName) {
        return productSink.asFlux().filter(product ->
                productName == null || product.getName().contains(productName)
        );
    }

}
