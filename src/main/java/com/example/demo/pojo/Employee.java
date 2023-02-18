package com.example.demo.pojo;

import lombok.*;

@Data
@AllArgsConstructor
public class Employee {
    private Company company;
    private String name;
    private int age;
}
