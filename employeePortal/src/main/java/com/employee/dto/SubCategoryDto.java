package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDto {

        private Long id;

        @NullOrNotBlank(min = 5, max = 50, message = "Sub-category name is required and must be between {min} and {max} characters.")
        private String name;

        @NotNull(message = "Department ID is required.")
        private Long departmentId;
}
