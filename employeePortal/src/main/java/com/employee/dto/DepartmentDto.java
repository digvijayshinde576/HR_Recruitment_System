package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

        private Long id;

        @NullOrNotBlank(min = 2, max = 100, message = "Department name must be between {min} and {max} characters.")
        private String name;

        @NullOrNotBlank(isMandatory = "no", min = 5, max = 255, message = "Description (optional) must be between {min} and {max} characters.")
        private String description;

        @NotNull(message = "Company ID is required.")
        private Long companyId;


}
