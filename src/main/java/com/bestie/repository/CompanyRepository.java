package com.bestie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestie.domain.Company;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findOneByCatId(String catId);

    List<Company> findByPCatId(String pCatId);

    @Override
    void delete(Company company);

}
