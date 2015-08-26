package com.bestie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bestie.domain.Company;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("select c from Company c where c.catId = ?1")
    Company findByCatId(String catId);

    List<Company> findAllByPCatId(String pCatId);
    
    List<Company> findAll();

    @Override
    void delete(Company company);

}
