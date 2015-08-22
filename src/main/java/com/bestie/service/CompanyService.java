package com.bestie.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bestie.domain.Company;
import com.bestie.repository.CompanyRepository;
import com.bestie.web.rest.dto.CompanyDTO;

/**
 * Service class for managing company.
 */
@Service
@Transactional
public class CompanyService {

    @Inject
    private CompanyRepository companyRepository;
    
	public void createCompanyInfo(CompanyDTO companyDTO){
    	Company company = new Company();
    	company.setIconLink(companyDTO.getIconLink());
    	company.setName(companyDTO.getName());
    	company.setWebLink(companyDTO.getWebLink());
    	company.setPlayLink(companyDTO.getPlayLink());
    	company.setAppleLink(companyDTO.getAppleLink());
    	company.setMsLink(companyDTO.getMsLink());
    	company.setCatId(companyDTO.getCatId());
    	company.setpCatId(companyDTO.getpCatId());
    	company.setInfo(companyDTO.getInfo());
    	companyRepository.save(company);
	}
}
