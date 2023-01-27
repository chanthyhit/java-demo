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
public class ShareController {

    private final DepartmentService service;

    public ShareController(DepartmentService service){
        this.service = service;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin/list")
    @ResponseBody
    public String adminAPIs(){
        return "register, modify user";
    }

    @GetMapping("/user/list")
    @ResponseBody
    public String userAPIs(){
        return "check, print user";
    }

    @GetMapping("/public/list")
    @ResponseBody
    public String publicAPIs(){
        return "public apis";
    }


    @GetMapping("/public/deps")
    @ResponseBody
    public List<Department> getDeps(){
        return service.getDeps();
    }

    @PostMapping("/public/post")
    @ResponseBody
    public Department save(){
        Department dep = new Department(6,"MAT","ACL03","DL","3");
        return service.save(dep);
    }
}
