package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
        private Long id;
        private Long employeeId;
        private String jobTitle;
        private String resumeUrl;
        private LocalDate applicationDate;
        private String status;
        private Long interviewerId;
}
