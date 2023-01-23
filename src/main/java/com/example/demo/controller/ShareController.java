package com.example.demo.controller;

import com.example.demo.pojo.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/share")
public class ShareController {

    private final DepartmentService service;

    public ShareController(DepartmentService service){
        this.service = service;
    }

    @GetMapping("/deps")
    @ResponseBody
    public List<Department> getDeps(){
        return service.getDeps();
    }

    @PostMapping("/post")
    @ResponseBody
    public Department save(){
        Department dep = new Department(6,"MAT","ACL03","DL","3");
        return service.save(dep);
    }
}
