package com.example.demo.repository;

import com.example.demo.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@ResponseBody
public interface RoleRepository extends JpaRepository<UserRole, Integer> {
    Set<UserRole> findRoleByUsername(String username);
}
