package com.example.demo.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String department;
    private String line;
    private String labor;
    private String shift;
}
