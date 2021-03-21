package com.rolandsall.product_service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private UUID productId;
    private String name;
    private String description;
    private double price;

}
