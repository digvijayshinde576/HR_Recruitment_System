package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDto {

        private Long id;

        @NotNull(message = "Candidate CV ID is required.")
        private Long candidateCVId;

        @NullOrNotBlank(min = 5, max = 50, message = "Screening result is required and must be between {min} and {max} characters.")
        private String screeningResult;

        @NullOrNotBlank(min = 5, max = 50, message = "Rejection reason must be between {min} and {max} characters if provided.", isMandatory = "no")
        private String rejectionReason;
}
