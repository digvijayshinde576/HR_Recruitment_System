package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {

        private Long id;

        @NullOrNotBlank(min = 5, max = 100, message = "Title is required and must be between {min} and {max} characters.")
        private String title;

        @NotNull(message = "Department ID is required.")
        private Long departmentId;


        private Long subCategoryId;


        private RequirementCriteriaDto criteria;
}
