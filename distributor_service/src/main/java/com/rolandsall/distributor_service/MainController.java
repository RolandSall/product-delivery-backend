package com.rolandsall.distributor_service;

import com.rolandsall.distributor_service.entity.Company;
import com.rolandsall.distributor_service.entity.CompanyProduct;
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

    @Autowired
    public MainController(CompanyService companyService, ProductService productService) {
        this.companyService = companyService;
        this.productService = productService;
    }

    @GetMapping("/try")
    public ResponseEntity addProductToCompanyStock() {
        Company company = companyService.getCompanyInfo(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(company);

    }
}