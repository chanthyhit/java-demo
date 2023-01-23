package com.example.demo.pojo;

public class Company {
    private String name;
    private String zip;

    public Company() {}

    public Company(String name, String zip) {
        this.name = name;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
