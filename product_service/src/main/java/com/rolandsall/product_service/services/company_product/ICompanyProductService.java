package com.rolandsall.product_service.services.company_product;

import com.rolandsall.product_service.entities.CompanyProduct;

import java.util.UUID;

public interface ICompanyProductService {

    CompanyProduct getCompanyProductServiceList(UUID uuid);

    void addProductToCompanyStock(UUID companyId, UUID productId);
}
