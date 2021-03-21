package com.rolandsall.product_service.daos;

import com.rolandsall.product_service.entities.CompanyProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductPerCompanyRepository extends MongoRepository<CompanyProduct, UUID> {
}
