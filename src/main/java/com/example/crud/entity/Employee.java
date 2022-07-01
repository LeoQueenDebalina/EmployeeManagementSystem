package com.example.crud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(length = 50, name = "name")
    private String name;
    @Column(length = 50, name = "age")
    private int age;
    @Column(length = 50, name = "designation")
    private String designation;
}
