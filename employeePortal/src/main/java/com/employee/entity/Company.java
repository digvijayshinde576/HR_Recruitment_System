package com.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "companies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(length = 100)
    private String website;

    @Column(nullable = false, length = 50)
    private String industry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Department> department;

//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Employee> employee;



}
