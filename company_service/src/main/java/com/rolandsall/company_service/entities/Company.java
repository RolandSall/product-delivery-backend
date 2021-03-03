package com.rolandsall.company_service.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Company {

    @Id
    private UUID id;
    private String companyName;
    private double price;

}


