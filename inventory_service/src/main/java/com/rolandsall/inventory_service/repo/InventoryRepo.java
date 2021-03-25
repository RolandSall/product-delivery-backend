package com.rolandsall.inventory_service.repo;

import com.rolandsall.inventory_service.entities.Inventory;
import com.rolandsall.inventory_service.entities.Product;

import java.util.Optional;
import java.util.UUID;

public interface InventoryRepo {
    void save(UUID companyId, Product product);

    Optional<Inventory> getProductListForCompany(UUID companyId);
}
