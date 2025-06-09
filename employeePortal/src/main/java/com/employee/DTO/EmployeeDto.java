package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String jobTitle;
        private String employeeCode;
        private String gender;
        private LocalDate dateOfBirth;
        private LocalDate dateOfJoining;
        private Long departmentId;
        private Long companyId;
        private Long subCategoryId;
        private String status;

}
