package com.employee.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequirementCriteriaDto {

        private Long id;

        @NotNull(message = "Position ID is required.")
        private Long positionId;

        @Min(value = 0, message = "Minimum experience must be at least 0 years.")
        private int minExperience;

        @NotEmpty(message = "At least one required skill must be provided.")
        private List<String> requiredSkills;
}
