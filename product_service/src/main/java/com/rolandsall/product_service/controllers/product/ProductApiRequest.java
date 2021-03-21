package com.rolandsall.product_service.controllers.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductApiRequest {
    private String name;
    private String description;
    private double price;
}
