package com.example.demo.service;

import com.example.demo.config.DatabaseConfig;
import com.example.demo.pojo.Department;
import com.example.demo.repository.DepartmentImp;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository=repository;
    }

    public List<Department> getDeps(){
        return repository.findAll();
    }
    public Department save(Department dep){
        return repository.save(dep);
    }

}
