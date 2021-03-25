package com.rolandsall.inventory_service.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyProduct {

    private Company company;
    private Product product;
}
