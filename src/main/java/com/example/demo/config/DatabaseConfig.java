package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


public class DatabaseConfig {

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("root")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        System.out.printf(userName+"===========================");
        return userName;
    }
}
