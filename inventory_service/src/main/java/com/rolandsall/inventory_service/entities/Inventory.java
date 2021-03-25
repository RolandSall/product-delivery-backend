package com.rolandsall.inventory_service.entities;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    private UUID companyId;
    private List<Product> productList;
}
