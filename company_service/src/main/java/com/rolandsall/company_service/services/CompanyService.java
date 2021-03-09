package com.rolandsall.company_service.services;

import com.rolandsall.company_service.daos.ICompanyRepositoryDAO;
import com.rolandsall.company_service.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService implements ICompanyService {

    private ICompanyRepositoryDAO iCompanyRepositoryDAO;

    @Autowired
    public CompanyService(ICompanyRepositoryDAO iCompanyRepositoryDAO) {
        this.iCompanyRepositoryDAO = iCompanyRepositoryDAO;
    }

    @Override
    public Company save(Company company) {
        UUID uuid = UUID.randomUUID();
        company.setId(uuid);
        return iCompanyRepositoryDAO.save(company);
    }

    @Override
    public UUID deleteCompany(UUID uuid) {
        iCompanyRepositoryDAO.deleteById(uuid);
        return uuid;
    }

    @Override
    public Company getCompanyById(UUID uuid) {

        return iCompanyRepositoryDAO.getOne(uuid);
    }

    @Override
    public List<Company> getAllCompanies() {
        return iCompanyRepositoryDAO.findAll();
    }
}
