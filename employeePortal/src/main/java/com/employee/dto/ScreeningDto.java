package com.employee.dto;


import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScreeningDto {

    private Long id;

    @NotNull(message = "Candidate CV ID is required for screening.")
    private Long candidateCVId;

    @NullOrNotBlank(isMandatory = "yes", message = "Screening result is required and must be 'Selected' or 'Rejected'.")
    private String screeningResult;

    @NullOrNotBlank(min = 5, max = 255, isMandatory = "no", message = "Rejection reason must be 5 to 255 characters if provided.")
    private String rejectionReason;
}
