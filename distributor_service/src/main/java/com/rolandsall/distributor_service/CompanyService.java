package com.rolandsall.distributor_service;

import com.rolandsall.distributor_service.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class CompanyService {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public CompanyService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }


    public Company getCompanyInfo(UUID companyId){
        Company company = webClientBuilder.build()
                .get()
                .uri("http://COMPANY-SERVICE/companies/168c4867-1675-479c-bef0-808a24ac383e")
                .retrieve()
                .bodyToMono(Company.class)
                .block();
        return company;
    }
}
