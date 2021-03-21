package com.rolandsall.product_service.services.company_product;

import com.rolandsall.product_service.daos.ProductPerCompanyRepository;
import com.rolandsall.product_service.entities.CompanyProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyProductService implements ICompanyProductService{

    ProductPerCompanyRepository productPerCompanyRepository;

    @Autowired
    public CompanyProductService(ProductPerCompanyRepository productPerCompanyRepository) {
        this.productPerCompanyRepository = productPerCompanyRepository;
    }

    @Override
    public CompanyProduct getCompanyProductServiceList(UUID uuid) {
        Optional<CompanyProduct> companyProductList = productPerCompanyRepository.findById(uuid);
        return companyProductList.get();
    }
}
