package com.rolandsall.distributor_service.entity;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyProduct {

    private Company company;
    private Product product;
}
