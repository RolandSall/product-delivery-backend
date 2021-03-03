package com.rolandsall.company_service.services;

import com.rolandsall.company_service.entities.Company;


import java.util.List;
import java.util.UUID;

public interface ICompanyService {

    Company save(Company company);

    UUID deleteCompany(UUID uuid);

    Company getCompanyById(UUID uuid);

    List<Company> getAllCompanies();

}
