package com.example.demo.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer>{
	
}
