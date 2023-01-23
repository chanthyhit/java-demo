package com.example.demo.pojo;

public class Employee {

    private Company company;
    private String name;
    private int age;

    public Employee() {}

    public Employee(Company company, String name, int age) {
        this.company = company;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company=" + company +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
