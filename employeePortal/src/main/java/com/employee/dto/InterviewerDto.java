package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewerDto {

        @NotNull(message = "Interviewer ID is required.")
        private Long id;

        @NullOrNotBlank(min = 5, max = 50, message = "Name must be between {min} and {max} characters.")
        private String name;

        @NullOrNotBlank(isEmail = "yes", min = 5, max = 50, message = "Valid email address is required.")
        private String email;

        @NullOrNotBlank(min = 5, max = 50, message = "Department name must be between {min} and {max} characters.")
        private String department;

        @NullOrNotBlank(min = 5, max = 50, message = "Job title must be between {min} and {max} characters.")
        private String jobTitle;

        @NotEmpty(message = "At least one application ID must be provided.")
        private List<Long> applicationIds;
}
