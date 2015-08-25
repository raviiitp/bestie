package com.bestie.web.rest;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bestie.domain.Company;
import com.bestie.repository.CompanyRepository;
import com.bestie.service.CompanyService;
import com.bestie.web.rest.dto.CompanyDTO;
import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing company info.
 */
@RestController
@RequestMapping("/company")
public class CompanyResource {

    private final Logger log = LoggerFactory.getLogger(CompanyResource.class);

    @Inject
    private CompanyRepository companyRepository;
    
    @Inject
    private CompanyService companyService;
    
    /**
     * GET  /:catId -> get the info of catId.
     */
    @RequestMapping(value = "/{catId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    ResponseEntity<Company> getCompany(@PathVariable String catId) {
        log.debug("REST request to get Category : {}", catId);
        return companyRepository.findOneByCatId(catId)
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    /**
     *  GET	/:pCatId -> get all children of a parent category id (pCatId).
     */
    @RequestMapping(value = "/{pCatId}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    ResponseEntity<List<Company>> getChildrenCompanies(@PathVariable String pCatId) {
        log.debug("REST request to get children of pCategory : {}", pCatId);
        List<Company> childrenCompanies = companyRepository.findAllByPCatId(pCatId);
        if(childrenCompanies != null){
        	return (new ResponseEntity<>(childrenCompanies, HttpStatus.OK));
        }else{
        	return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }
    
    /**
     * POST  /register -> insert/update the company.
     */
    @RequestMapping(value = "/insertCompany",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @Timed
    public ResponseEntity<?> insertCompany(@Valid @RequestBody CompanyDTO companyDTO, HttpServletRequest request) {
    	
    	companyRepository.findOneByCatId(companyDTO.getCatId())
    	.map(company -> {
    		companyRepository.delete(company);
    		companyService.createCompanyInfo(companyDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);
    	});

		companyService.createCompanyInfo(companyDTO);
    	
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
