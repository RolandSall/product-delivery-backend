package com.rolandsall.company_service.controllers.company;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyApiResponse {

    private UUID id;
    private String companyName;
    private double price;
}
