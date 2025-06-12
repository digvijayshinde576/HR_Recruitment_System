package com.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {

    @Id
    @SequenceGenerator(name = "department_seq", sequenceName = "department_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @OneToMany(mappedBy = "departmentEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SubCategoryEntity> subCategoryEntities;

    @OneToMany(mappedBy = "departmentEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EmployeeEntity> employeeEntities;
}
