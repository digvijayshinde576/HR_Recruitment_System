package com.employee.dto;


import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {

    private Long id;

    @NullOrNotBlank(min = 2, max = 100, isMandatory = "yes", message = "Position title is required and must be between {min} and {max} characters.")
    private String title;

    @NotNull(message = "Department ID is required for the position.")
    private Long departmentId;

    @NotNull(message = "Sub-category ID is required for the position.")
    private Long subCategoryId;

    @Valid
    @NotNull(message = "Requirement criteria is required.")
    private RequirementCriteriaDto criteria;
}
