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

import com.example.demo.model.Department;
import com.example.demo.model.DepartmentDTO;
import com.example.demo.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

//	@GetMapping("getAllDepartment")
//	public List<Department> getAllDepartment(){
//		return departmentService.getAllDepartment();
//	}

	@GetMapping
    public List<DepartmentDTO> getDepartmentList(){
        ModelMapper modelMapper = new ModelMapper();
        List<Department> departmentList = departmentService.getAllDepartment();
        return Arrays.asList(modelMapper.map(departmentList, DepartmentDTO[].class));
    }

//	@GetMapping("getDepartment/{id}")
//	public Optional<Department> getDepartment(@PathVariable String id){
//		return departmentService.getDepartment(id);
//	}

	@GetMapping(value ="getDepartment/{departmentId}")
	public DepartmentDTO getDepartment(@PathVariable("departmentId") int departmentId){
	    ModelMapper modelMapper = new ModelMapper();
	    Optional<Department> department = departmentService.getDepartment(departmentId);
	    return modelMapper.map(department, DepartmentDTO.class);
}

//	@PostMapping("addDepartment")
//	public void addDepartment(@RequestBody Department dept){
//		departmentService.addDepartment(dept);
//	}
    @PostMapping
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Department department = modelMapper.map(departmentDTO, Department.class);
        department = departmentService.addDepartment(department);
        return modelMapper.map(department, DepartmentDTO.class);
    }

//	@PutMapping("updateDepartment/{id}")
//	public void updateDepartment(@RequestBody Department dept, @PathVariable String id){
//		departmentService.updateDepartment(dept,id);
//	}

    @PutMapping(value ="/{departmentId}")
    public DepartmentDTO updateDepartment(@PathVariable("departmentId") int departmentId, @RequestBody DepartmentDTO departmentDTO){
        ModelMapper modelMapper = new ModelMapper();
        Department department = modelMapper.map(departmentDTO, Department.class);
        departmentService.updateDepartment(department, departmentId);
        return modelMapper.map(department, DepartmentDTO.class);
    }
	
//	@DeleteMapping("deleteDepartment/{id}")
//	public void deleteDepartment(@PathVariable String id){
//		departmentService.deleteDepartment(id);
//	}

    @DeleteMapping(value ="/{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") int departmentId){
        departmentService.deleteDepartment(departmentId);
    }

    @GetMapping(value ="/company/{companyId}")
    public List<DepartmentDTO> getDepartmentsByCompany(@PathVariable("companyId") int companyId){
        ModelMapper modelMapper = new ModelMapper();
        List<Department> departmentList = departmentService.getDepartmentsByCompany(companyId);
        return Arrays.asList(modelMapper.map(departmentList, DepartmentDTO[].class));
    }

}


