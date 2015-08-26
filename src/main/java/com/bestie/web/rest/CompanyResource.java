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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/")
public class CompanyResource {

    private final Logger log = LoggerFactory.getLogger(CompanyResource.class);

    @Inject
    private CompanyRepository companyRepository;
    
    @Inject
    private CompanyService companyService;
    
    @RequestMapping(value= "companyList",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?>getAll(){
    	List<Company> companyList = companyRepository.findAll();
    	if(companyList != null){
    		return new ResponseEntity<>(companyList, HttpStatus.OK);
    	}else{
    		return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    	}
    }
    
    /**
     * GET http://localhost:8080/company?tag=ct&id=friends -> get the info of catId.
     * GET http://localhost:8080/company?tag=ch&id=SocialNetworking
     */
    @RequestMapping(value = "company",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    ResponseEntity<?> getCompany(@RequestParam String tag, String id) {
        log.debug("REST request to get Category : {}", tag + " " + id);
        if(tag.equals("ct")){
        	log.debug("catId is called");
        	//List<Company> companyList = companyService.getAllByCatId(id);
        	Company company = companyRepository.findByCatId(id);
            if(company == null){
            	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
            	return new ResponseEntity<>(company, HttpStatus.OK);
            }
        }
        else if(tag.equals("ch")){
        	log.debug("pCatId is called");
        	List<Company> childrenCompanies = companyRepository.findAllByPCatId(id);
            if(childrenCompanies != null){
            	return (new ResponseEntity<>(childrenCompanies, HttpStatus.OK));
            }else{
            	return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * POST  /insertCompany -> insert/update the company.
     */
    @RequestMapping(value = "company/insertCompany",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @Timed
    public ResponseEntity<?> insertCompany(@Valid @RequestBody CompanyDTO companyDTO, HttpServletRequest request) {
    	
/*    	companyRepository.findByCatId(companyDTO.getCatId())
    	.map(company -> {
    		companyRepository.delete(company);
    		companyService.createCompanyInfo(companyDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);
    	});*/

		companyService.createCompanyInfo(companyDTO);
    	
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    

    

}
