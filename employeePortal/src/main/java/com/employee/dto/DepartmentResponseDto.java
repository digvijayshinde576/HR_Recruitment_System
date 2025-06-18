package com.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentResponseDto {

    private Long id;
    private String name;
    private String description;
    private List<SubCategoryDto> subCategories;
    private List<EmployeeDto> employees;
}
