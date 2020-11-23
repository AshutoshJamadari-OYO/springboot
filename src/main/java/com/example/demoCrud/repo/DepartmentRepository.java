package com.example.demoCrud.repo;
import java.util.List;

import com.example.demoCrud.model.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface DepartmentRepository extends CrudRepository<Department,Integer>{
    public List<Department> findByCompanyCompanyId(int companyId);
}