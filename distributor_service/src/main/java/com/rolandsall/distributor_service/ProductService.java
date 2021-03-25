package com.rolandsall.distributor_service;

import com.rolandsall.distributor_service.entity.Company;
import com.rolandsall.distributor_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class ProductService {

    private WebClient webClient;

    @Autowired
    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Product getProductInfo(UUID productId) {
        Product product = webClient
                .get()
                .uri("http://PRODUCT-SERVICE/products/"+productId)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
        return product;
    }
}
