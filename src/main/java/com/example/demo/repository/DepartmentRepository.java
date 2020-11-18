package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Department;

@Repository
@Transactional
public interface DepartmentRepository extends CrudRepository<Department,Integer>{

	public List<Department> findByCompanyCompanyId(int companyId);

//    @Override
//    List<Department> findAll();

}