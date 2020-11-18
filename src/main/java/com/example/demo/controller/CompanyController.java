package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.model.CompanyDTO;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@Autowired
	private ModelMapper modelMapper;
//	@GetMapping
//	public List<Company> getAllCompany(){
//		return companyService.getAllCompany();
//	}

	@GetMapping
	public List<CompanyDTO> getCompanyList(){
//	    ModelMapper modelMapper = new ModelMapper();
	    List<Company> companyList = companyService.getAllCompany();
	    return Arrays.asList(modelMapper.map(companyList, CompanyDTO[].class));
	}
	
//	@GetMapping("getCompany/{id}")
//	public Optional<Company> getCompany(@PathVariable String id){
//		return companyService.getCompany(id);
//	}
	@GetMapping(value="/{companyId}")
	public CompanyDTO getCompany(@PathVariable("companyId") int companyId){
//	    ModelMapper modelMapper = new ModelMapper();
	    Optional<Company> company = companyService.getCompany(companyId);
	    return modelMapper.map(company, CompanyDTO.class);
	}

	
//	@PostMapping
//	public void addCompany(@RequestBody Company comp){
//		companyService.addCompany(comp);
//	}


	@PostMapping
	public CompanyDTO addCompany(@RequestBody CompanyDTO companyDTO){
		System.out.println(companyDTO.toString());

//		ModelMapper modelMapper = new ModelMapper();
	    Company company = modelMapper.map(companyDTO, Company.class);

	    System.out.println(company.toString());
	    company  = companyService.addCompany(company);
		System.out.println(company.toString());

		return modelMapper.map(company, CompanyDTO.class);
	}
	
//	@PutMapping("updateCompany/{id}")
//	public void updateCompany(@RequestBody Company comp, @PathVariable String id){
//		companyService.updateCompany(comp,id);
//	}
	
	@PutMapping(value ="updateCompany/{companyId}")
	public CompanyDTO updateCompany(@PathVariable("companyId") int companyId, @RequestBody CompanyDTO companyDTO){
//	    ModelMapper modelMapper = new ModelMapper();
	    Company company = modelMapper.map(companyDTO, Company.class);
	    companyService.updateCompany(company, companyId);
	    return modelMapper.map(company, CompanyDTO.class);
	}
	
	@DeleteMapping("deleteCompany/{companyId}")
	public void deleteCompany(@PathVariable int companyId){
		companyService.deleteCompany(companyId);
	}
		
}
