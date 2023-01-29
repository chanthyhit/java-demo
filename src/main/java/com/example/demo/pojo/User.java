package com.example.demo.pojo;

import lombok.*;

import javax.persistence.*;

/**
 * This should reflect default user class in spring security and our database.
 */
@Entity
@Table(name = "user_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String password;
}
