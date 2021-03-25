package com.rolandsall.inventory_service;

import com.rolandsall.inventory_service.entities.Company;
import com.rolandsall.inventory_service.entities.Product;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddProductToCompanyApiRequest {
    private Company company;
    private Product product;
}
