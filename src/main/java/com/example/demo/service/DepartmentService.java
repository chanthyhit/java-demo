package com.example.demo.service;

import com.example.demo.pojo.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository=repository;
    }

    public List<Department> getDeps(){
        return repository.findAll();
    }

    public Department findOneById(int id){
        return repository.findOneById(id);
    }
    public Department save(Department dep){
        return repository.save(dep);
    }

}
