package com.example.demoCrud.controller;

import com.example.demoCrud.model.dto.EmployeeDTO;
import com.example.demoCrud.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import com.example.demoCrud.service.EmployeeService;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/employee",produces = "application/json",consumes = "application/json")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "addEmployee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println("*****");
        System.out.println(employeeDTO.toString());

        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        System.out.println(employee.toString());
        employee = employeeService.addEmployee(employee);
        System.out.println(employee.toString());

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @GetMapping("getEmployeeList")
    public List<EmployeeDTO> getEmployeeList(){
        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employeeList = employeeService.getAllEmployee();
        System.out.println(employeeList);
        return Arrays.asList(modelMapper.map(employeeList, EmployeeDTO[].class));
    }

    @GetMapping(value ="getEmployee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable("employeeId") int employeeId){
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = employeeService.getEmployee(employeeId);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @PutMapping(value ="updateEmployee/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody EmployeeDTO employeeDTO){
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee = employeeService.updateEmployee(employeeId, employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @DeleteMapping(value ="deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @GetMapping(value ="/department/{departmentId}")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable("departmentId") int departmentId){
        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employeeList = employeeService.getEmployeesByDepartment(departmentId);
        return Arrays.asList(modelMapper.map(employeeList, EmployeeDTO[].class));
    }

    @GetMapping("/ping")
    public String ping(){
        return "testing";
    }

//    @GetMapping("/kafkaMsg/{msg}")
//    public void sendMessage(@PathVariable String msg) {
//        kafkaTemplate.send("test", msg);
//    }

}
