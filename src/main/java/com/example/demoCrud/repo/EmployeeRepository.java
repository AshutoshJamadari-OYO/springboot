package com.example.demoCrud.repo;

import com.example.demoCrud.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    public List<Employee> findByDepartmentDepartmentId(int departmentId);
}
