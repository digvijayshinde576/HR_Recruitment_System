package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
        private Long id;
        private String name;
        private String address;
        private String email;
        private String phone;
        private String website;
        private String industry;

}
