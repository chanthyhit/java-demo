package com.example.demo.service;

import com.example.demo.pojo.Department;
import com.example.demo.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    Logger log = LoggerFactory.getLogger(DepartmentService.class);
    private final DepartmentRepository repository;

    @Autowired
    Environment environment;

    public DepartmentService(DepartmentRepository repository){
        this.repository=repository;
    }

    public List<Department> getDeps(){
        log.info("Pulling data from database");
        String ds = environment.getProperty("spring.datasource.driverClassName");
        log.info(ds+"===============");
        return repository.findAll();
    }

    public Department findOneById(int id){
        return repository.findOneById(id);
    }
    public Department save(Department dep){
        return repository.save(dep);
    }

}
