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

//import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
//	@GetMapping("/{departmentId}/getAllEmployee")
//	public List<Employee> getAllEmployee(@PathVariable String departmentId){
//		return employeeService.getAllEmployee(departmentId);
//	}

	@GetMapping
    public List<EmployeeDTO> getEmployeeList(){
        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employeeList = employeeService.getAllEmployee();
        return Arrays.asList(modelMapper.map(employeeList, EmployeeDTO[].class));
    }

	@GetMapping("getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}

//	@PostMapping("/{departmentId}/addEmployee")
//	public  addEmployee(@RequestBody Employee employee, @PathVariable String departmentId){
//		employee.setDepartment(new Department(departmentId ,"","","","","","","",""));
//		employeeService.addEmployee(employee);
//	}
	
	@PostMapping
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employee = employeeService.addEmployee(employee);
		return modelMapper.map(employee, EmployeeDTO.class);
	}
	
//	@PutMapping("/{departmentId}/updateEmployee/{id}")
//	public void updateEmployee(@RequestBody Employee employee, @PathVariable String id, @PathVariable String departmentId){
//		employee.setDepartment(new Department(departmentId ,"","","","","","","",""));
//		employeeService.updateEmployee(employee);
//	}

	@PutMapping("updateEmployee/{employeeId}")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("employeeId") int employeeId){
		ModelMapper modelMapper = new ModelMapper();
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employeeService.updateEmployee(employee,employeeId);
		
//		employeeService.updateEmployee(employee);
		return modelMapper.map(employee, EmployeeDTO.class);
	}
	
	@DeleteMapping("/{departmentId}/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
	}

    @GetMapping(value ="/department/{departmentId}")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable("departmentId") int departmentId){
        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employeeList = employeeService.getEmployeesByDepartment(departmentId);
        return Arrays.asList(modelMapper.map(employeeList, EmployeeDTO[].class));
    }
	
}
