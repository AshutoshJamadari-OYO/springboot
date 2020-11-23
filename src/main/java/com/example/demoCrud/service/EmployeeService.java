package com.example.demoCrud.service;

import com.example.demoCrud.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demoCrud.repo.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //For adding the new employee in the table
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //For getting list all the employees in the table
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    //For getting particular employee by employeeId
    public Employee getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    //For updating the employee details for a particular Id
    public Employee updateEmployee(int employeeId, Employee employee){
//        Employee update = employeeRepository.findById(employeeId).get();
//        update.setEmployeeId(employeeId);
//        return employeeRepository.save(update);
        return employeeRepository.save(employee);
    }

    //For deleting a employee from the employee table for a particular Id
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getEmployeesByDepartment(int departmentId){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findByDepartmentDepartmentId(departmentId).forEach(employeeList::add);
        return employeeList;
    }

}
