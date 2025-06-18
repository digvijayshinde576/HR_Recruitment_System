package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubCategoryDto {

    @NullOrNotBlank(min = 2, max = 100, isMandatory = "yes", message = "Sub-category name is required and must be between {min} and {max} characters.")
    private String name;

//    @NotNull(message = "Department ID is required for sub-category.")
//    private Long departmentId;


}
