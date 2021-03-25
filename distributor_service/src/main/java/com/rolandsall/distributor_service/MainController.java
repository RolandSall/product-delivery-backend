package com.rolandsall.distributor_service;

import com.rolandsall.distributor_service.entity.Company;
import com.rolandsall.distributor_service.entity.CompanyProduct;
import com.rolandsall.distributor_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class MainController {

    private CompanyService companyService;
    private ProductService productService;
    private final DistributorService distributorService;

    @Autowired
    public MainController(CompanyService companyService, ProductService productService, DistributorService distributorService) {
        this.companyService = companyService;
        this.productService = productService;
        this.distributorService = distributorService;
    }

    @PostMapping("/add-product")
    public ResponseEntity addProductToCompanyStock(@RequestBody AddProductToStockRequest request) {
        Company company = companyService.getCompanyInfo(request.getCompanyId());
        Product product = productService.getProductInfo(request.getProductId());
        product.setQuantity(request.getQuantity());
        CompanyProduct companyProduct = buildDistributorRequest(company, product);
        CompanyProduct companyProductResponse = distributorService.addToStock(companyProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyProductResponse);

    }

    private CompanyProduct buildDistributorRequest(Company company, Product product) {
        return new CompanyProduct().builder()
                .company(company)
                .product(product)
                .build();
    }
}

