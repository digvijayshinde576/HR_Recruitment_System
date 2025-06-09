package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

        private Long id;

        @NullOrNotBlank(min = 2, max = 100, message = "Company name must be between {min} and {max} characters.")
        private String name;

        @NullOrNotBlank(min = 5, max = 255, message = "Address must be between {min} and {max} characters.")
        private String address;

        @NullOrNotBlank(min = 10, max = 15, message = "Phone number must be between {min} and {max} digits.")
        private String phone;

        @NullOrNotBlank(isMandatory = "no", min = 5, max = 100, message = "Website URL must be between {min} and {max} characters if provided.")
        private String website;

        @NullOrNotBlank(min = 2, max = 50, message = "Industry must be between {min} and {max} characters.")
        private String industry;
}
