package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	
	public List<Employee> findByDepartmentDepartmentId(int departmentId);
	
//	@Override
//	List<Employee> findAll();
 }
