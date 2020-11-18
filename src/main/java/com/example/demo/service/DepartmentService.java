package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartment() {
		return (List<Department>) departmentRepository.findAll();
	}

	public Optional<Department> getDepartment(int id) {
		return departmentRepository.findById(id);
	}

	public Department addDepartment(Department dept) {
		return departmentRepository.save(dept);
	}

	public void updateDepartment(Department dept, int id) {
		departmentRepository.findById(id).get();
//		dept.setId(id);
		departmentRepository.save(dept);
	}

	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
	}

	public List<Department> getDepartmentsByCompany(int companyId){
        List<Department> departmentList = new ArrayList<>();
        departmentRepository.findByCompanyCompanyId(companyId).forEach(departmentList::add);
        return departmentList;
    }
	
}




