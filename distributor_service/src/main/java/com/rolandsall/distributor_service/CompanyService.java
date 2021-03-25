package com.rolandsall.distributor_service;

import com.rolandsall.distributor_service.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class CompanyService {

    private WebClient webClient;

    @Autowired
    public CompanyService(WebClient webClient) {
        this.webClient = webClient;
    }


    public Company getCompanyInfo(UUID companyId) {
        Company company = webClient
                .get()
                .uri("http://COMPANY-SERVICE/companies/" + companyId)
                .retrieve()
                .bodyToMono(Company.class)
                .block();
        return company;
    }
}


