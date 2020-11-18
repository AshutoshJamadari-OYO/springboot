package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
//		List<Employee> employee= new ArrayList<>();
//		employeeRepository.findByDepartmentDepartmentId(departmentId).forEach(employee::add);
//		return employee;
		return (List<Employee>) employeeRepository.findAll();
	}

	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void updateEmployee(Employee employee, int employeeId) {
//		employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
//		employee.setId(employeeId);
		employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public List<Employee> getEmployeesByDepartment(int departmentId){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findByDepartmentDepartmentId(departmentId).forEach(employeeList::add);
        return employeeList;
    }
}
