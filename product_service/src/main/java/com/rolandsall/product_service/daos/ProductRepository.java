package com.rolandsall.product_service.daos;

import com.rolandsall.product_service.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {



}
