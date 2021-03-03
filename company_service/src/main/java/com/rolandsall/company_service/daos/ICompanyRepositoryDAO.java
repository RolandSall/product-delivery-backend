package com.rolandsall.company_service.daos;

import com.rolandsall.company_service.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICompanyRepositoryDAO extends JpaRepository<Company, UUID> {
}
