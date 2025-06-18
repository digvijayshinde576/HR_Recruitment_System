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
public class CompanyResponseDto {

    private Long id;
    private String name;
    private String address;
    private String industry;
    private String website;
    private List<DepartmentResponseDto> departments;
}
