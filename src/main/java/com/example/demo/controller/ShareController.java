package com.example.demo.controller;

import com.example.demo.pojo.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String s = String.format("%s %s", userDetails.getUsername(), userDetails.getPassword());
        System.out.println(s);
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout";
    }

    @GetMapping("/public/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin/list")
    @ResponseBody
    public String adminAPIs(){
        return "register, modify users";
    }

    @GetMapping("/user/list")
    @ResponseBody
    public String userAPIs(){
        return "check, print user";
    }

    @GetMapping("/public/list")
    @ResponseBody
    public String publicAPIs(){
        return "public apis. I'm testing CICD in AWS.";
    }


    @GetMapping("/public/deps")
    @ResponseBody
    public List<Department> getDeps(){
        return service.getDeps();
    }

    @GetMapping("/public/dep/{id}")
    @ResponseBody
    public Department getDep(@PathVariable int id){return service.findOneById(id);}

    @PostMapping("/public/post")
    @ResponseBody
    public Department save(){
        Department dep = new Department(6,"MAT","ACL03","DL","3");
        return service.save(dep);
    }
}
