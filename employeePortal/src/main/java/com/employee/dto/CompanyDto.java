package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto {

    @NullOrNotBlank(min = 2, max = 100, isMandatory = "yes", message = "Company name is required and must be between {min} and {max} characters.")
    private String name;

    @NullOrNotBlank(min = 5, max = 255, isMandatory = "no", message = "Address (optional) must be between {min} and {max} characters if provided.")
    private String address;

    @NullOrNotBlank(min = 2, max = 50, isMandatory = "no", message = "Industry (optional) must be between {min} and {max} characters if provided.")
    private String industry;

    @NullOrNotBlank(min = 2, max = 100, isMandatory = "yes", message = "Website must be between {min} and {max} characters if provided.")
    private String website;

//    private List<DepartmentDto> departments;


}

