package com.rolandsall.company_service.controllers.company;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyApiRequest {
    private String companyName;
    private double price;
}
