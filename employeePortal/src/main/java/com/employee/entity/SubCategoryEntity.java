package com.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sub_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryEntity {

    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "subCategoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeEntity> employeeEntities;


}
