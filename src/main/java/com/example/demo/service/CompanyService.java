package com.example.demo.service;


import java.util.List;
import java.util.Optional;

//import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getAllCompany() {
		return (List<Company>) companyRepository.findAll();
	}

	public Optional<Company> getCompany(int id) {
		return companyRepository.findById(id);
	}

	public Company addCompany(Company comp) {
		return companyRepository.save(comp);
	}

	public void updateCompany(Company comp, int id) {
//		companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
		companyRepository.findById(id).get();
//		comp.setCompanyId(id);
		companyRepository.save(comp);
	}

	public void deleteCompany(int id) {
		companyRepository.deleteById(id);
	}
	
}
