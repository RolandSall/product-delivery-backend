package com.rolandsall.inventory_service;

import com.netflix.discovery.converters.Auto;
import com.rolandsall.inventory_service.entities.CompanyProduct;
import com.rolandsall.inventory_service.entities.Inventory;
import com.rolandsall.inventory_service.entities.Product;
import com.rolandsall.inventory_service.services.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MainController {

    private AddProductService productService;

    @Autowired
    public MainController(AddProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/test")
    public String greeting(){
        return "Inventory-Service Is Up";
    }


    @PostMapping("/add-product")
    public ResponseEntity addProductToCompanyStock(@RequestBody AddProductToCompanyApiRequest request){
        productService.addProductToCompanyStock(request.getCompany().getId(),request.getProduct());
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @GetMapping("/companies/{companyId}/products")
    public ResponseEntity addProductToCompanyStock(@PathVariable("companyId") UUID companyId){
        Inventory companyInventory = productService.getCompanyInventory(companyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyInventory);
    }


}
