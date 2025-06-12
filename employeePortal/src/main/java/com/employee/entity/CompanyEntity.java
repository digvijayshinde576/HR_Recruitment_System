package com.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "companies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(length = 100)
    private String website;

    @Column(nullable = false, length = 50)
    private String industry;

    @OneToMany(mappedBy = "companyEntity", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DepartmentEntity> departmentEntity;

    @OneToMany(mappedBy = "companyEntity", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EmployeeEntity> employeeEntities;
}
