package com.rolandsall.inventory_service.services;

import com.rolandsall.inventory_service.entities.Inventory;
import com.rolandsall.inventory_service.entities.Product;
import com.rolandsall.inventory_service.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddProductService {

    InventoryRepo inventoryRepo;

    @Autowired
    public AddProductService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public void addProductToCompanyStock(UUID companyId, Product product){
        inventoryRepo.save(companyId,product);
    }

    public Inventory getCompanyInventory(UUID companyId){
        return inventoryRepo.getProductListForCompany(companyId).get();
    }
}
