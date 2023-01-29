package com.example.demo.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {
    private Company company;
    private String name;
    private int age;
}
