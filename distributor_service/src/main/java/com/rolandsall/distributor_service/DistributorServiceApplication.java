package com.rolandsall.distributor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DistributorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributorServiceApplication.class, args);
    }



    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder(){
        return  WebClient.builder();
    }

}
