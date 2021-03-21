package com.rolandsall.product_service.services.company_product;
import com.rolandsall.product_service.daos.ProductPerCompanyRepository;
import com.rolandsall.product_service.entities.CompanyProduct;
import com.rolandsall.product_service.entities.Product;
import com.rolandsall.product_service.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyProductService implements ICompanyProductService{

    ProductPerCompanyRepository productPerCompanyRepository;

    IProductService productService;

    @Autowired
    public CompanyProductService(ProductPerCompanyRepository productPerCompanyRepository, IProductService productService) {
        this.productPerCompanyRepository = productPerCompanyRepository;
        this.productService = productService;
    }

    @Override
    public CompanyProduct getCompanyProductServiceList(UUID uuid) {
        Optional<CompanyProduct> companyProductList = productPerCompanyRepository.findById(uuid);
        return companyProductList.get();
    }

    @Override
    public void addProductToCompanyStock(UUID companyId, UUID productId) {
        Product product = productService.getProductById(productId);
        CompanyProduct company = productPerCompanyRepository.findById(companyId).get();
        company.getProductList().add(product);
        productPerCompanyRepository.save(company);
    }
}
