package com.rolandsall.distributor_service;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddProductToStockRequest {
    private UUID companyId;
    private UUID productId;
    private int quantity;
}
