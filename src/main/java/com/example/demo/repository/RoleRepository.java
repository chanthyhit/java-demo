package com.example.demo.repository;

import com.example.demo.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface RoleRepository extends JpaRepository<UserRole, Integer> {
}
