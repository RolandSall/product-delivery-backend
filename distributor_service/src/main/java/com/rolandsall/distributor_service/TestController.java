package com.rolandsall.distributor_service;

import com.rolandsall.distributor_service.entity.Company;
import com.rolandsall.distributor_service.entity.CompanyProduct;
import com.rolandsall.distributor_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class TestController {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public TestController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }


    @GetMapping("/tryConnection")
    public ResponseEntity tryCon() {
        webClientBuilder.build().get().uri("http://company-service:8081/companies/318c08f3-acbe-4f31-ba19-5a06801cbf20")
                .retrieve()
                .bodyToMono(Company.class)
                .block();
        return ResponseEntity.status(HttpStatus.CREATED).body("companyProductResponse");

    }

}
