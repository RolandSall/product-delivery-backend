package com.rolandsall.product_service.services.product;

import com.rolandsall.product_service.entities.Product;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product getProductById(UUID productId);
}
