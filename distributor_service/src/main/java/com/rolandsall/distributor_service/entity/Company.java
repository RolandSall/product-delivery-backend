package com.rolandsall.distributor_service.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    private UUID id;
    private String companyName;
    private double price;
}
