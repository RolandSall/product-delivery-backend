package com.rolandsall.distributor_service;

import com.google.common.net.HttpHeaders;
import com.rolandsall.distributor_service.entity.Company;
import com.rolandsall.distributor_service.entity.CompanyProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DistributorService {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public DistributorService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }


    public CompanyProduct addToStock(CompanyProduct companyProduct){
        CompanyProduct response = webClientBuilder.build().post().
                uri("http://INVENTORY-SERVICE/add-product")
                .body(Mono.just(companyProduct), CompanyProduct.class)
                .retrieve()
                .bodyToMono(CompanyProduct.class)
                .block();
        return response;
    }
}
