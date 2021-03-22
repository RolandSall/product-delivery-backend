package com.rolandsall.product_service.controllers.product;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductApiResponse {
    private UUID id;
    private String name;
    private String description;
    private double price;
}
