package com.rolandsall.inventory_service.repo;

import com.rolandsall.inventory_service.entities.Inventory;
import com.rolandsall.inventory_service.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InventoryRepoImp implements InventoryRepo {

    List<Inventory> inventories = new ArrayList<>();

    @Override
    public void save(UUID companyId, Product product) {
        Optional<Inventory> productListForCompany = getProductListForCompany(companyId);
        if(productListForCompany.isPresent()){
            productListForCompany.get().getProductList().add(product);
           } else {
            ArrayList<Product> companyProductList = new ArrayList<>();
            companyProductList.add(product);
            inventories.add(new Inventory(companyId, companyProductList));
        }

    }

    @Override
    public Optional<Inventory> getProductListForCompany(UUID companyId) {
        for (Inventory inventory : inventories) {
            if (inventory.getCompanyId().equals(companyId)) {
                return Optional.ofNullable(inventory);
            }
        }
        return Optional.ofNullable(null);
    }
}
