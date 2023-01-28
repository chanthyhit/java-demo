package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String department;
    private String line;
    private String labor;
    private String shift;

    public Department() {
    }

    public Department(int id, String department, String line, String labor, String shift) {
        this.id = id;
        this.department = department;
        this.line = line;
        this.labor = labor;
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", line='" + line + '\'' +
                ", labor='" + labor + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && Objects.equals(department, that.department) && Objects.equals(line, that.line) && Objects.equals(labor, that.labor) && Objects.equals(shift, that.shift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, line, labor, shift);
    }
}
