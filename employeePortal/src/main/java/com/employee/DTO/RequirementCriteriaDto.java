package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequirementCriteriaDto {
        private Long id;
        private Long positionId;
        private int minExperience;
        private List<String> requiredSkills;

}
