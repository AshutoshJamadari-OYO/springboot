package com.example.demoCrud.repo;

import com.example.demoCrud.model.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer>{

}
