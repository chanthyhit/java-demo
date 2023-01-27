package com.example.demo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class RoleChecker {

    public static boolean hasRole(String role) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

            Collection<? extends GrantedAuthority> authorities =
                    SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }
}

