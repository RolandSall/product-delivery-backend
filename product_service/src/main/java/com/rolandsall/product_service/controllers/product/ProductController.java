package com.rolandsall.product_service.controllers.product;

import com.rolandsall.product_service.entities.CompanyProduct;
import com.rolandsall.product_service.entities.Product;
import com.rolandsall.product_service.services.company_product.CompanyProductService;
import com.rolandsall.product_service.services.company_product.ICompanyProductService;
import com.rolandsall.product_service.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ProductController {


    private IProductService productService;
    private ICompanyProductService iCompanyProductService;

    @Autowired
    public ProductController(IProductService productService, ICompanyProductService iCompanyProductService) {
        this.productService = productService;
        this.iCompanyProductService = iCompanyProductService;
    }

    @GetMapping("/products")
    public ResponseEntity findAllProducts() {
        try {
            List<Product> productList = productService.getAllProducts();
            List<ProductApiResponse> response = buildListOfResponse(productList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity findProductById(@PathVariable UUID productId) {
        try {
            Product product = productService.getProductById(productId);
            ProductApiResponse response = buildResponse(product);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/products/companies/{companyId}")
    public ResponseEntity findAllProductsByCompanyId(@PathVariable("companyId") UUID companyId) {
        try {
            CompanyProduct productList = iCompanyProductService.getCompanyProductServiceList(companyId);
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/products/{productId}/companies/{companyId}")
    public ResponseEntity addProductToCompanyStock(@PathVariable UUID productId,@PathVariable UUID companyId) {
        try {
            iCompanyProductService.addProductToCompanyStock(companyId,productId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product Was Added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductApiRequest productApiRequest) {
        try {
            Product product = productService.createProduct(buildProductFrom(productApiRequest));
            ProductApiResponse response = buildResponse(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private Product buildProductFrom(ProductApiRequest productApiRequest) {
        return new Product().builder()
                .name(productApiRequest.getName())
                .description(productApiRequest.getDescription())
                .price(productApiRequest.getPrice())
                .build();
    }


    private List<ProductApiResponse> buildListOfResponse(List<Product> productList) {
        List<ProductApiResponse> responseList = new ArrayList<>();
        for (Product product : productList) {
            responseList.add(buildResponse(product));
        }
        return responseList;
    }

    private ProductApiResponse buildResponse(Product product) {
        return new ProductApiResponse().builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
