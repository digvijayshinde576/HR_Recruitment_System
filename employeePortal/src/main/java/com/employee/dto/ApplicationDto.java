package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

        private Long id;

        @NotNull(message = "Employee ID is required.")
        private Long employeeId;

        @NullOrNotBlank(min = 2, max = 100, message = "Job title must be between {min} and {max} characters long.")
        private String jobTitle;

        @NullOrNotBlank(isMandatory = "no", min = 5, max = 255, message = "Resume URL (optional) must be between {min} and {max} characters if provided.")
        private String resumeUrl;

        @PastOrPresent(message = "Application date must be today or in the past.")
        @NotNull(message = "Application date is required.")
        private LocalDate applicationDate;

        @NullOrNotBlank(message = "Status is required.")
        private String status;

        @NotNull(message = "Interviewer ID is required.")
        private Long interviewerId;
}
