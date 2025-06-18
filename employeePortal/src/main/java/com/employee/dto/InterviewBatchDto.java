package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InterviewBatchDto {

    private Long id;

    @NotNull(message = "Interview date is required.")
    @FutureOrPresent(message = "Interview date must be today or in the future.")
    private LocalDate interviewDate;

    @NullOrNotBlank(min = 4, max = 20, isMandatory = "yes", message = "Time slot is required and must be between {min} and {max} characters.")
    private String timeSlot;

    @NotNull(message = "Position ID is required.")
    private Long positionId;

    @NotEmpty(message = "At least one candidate ID must be provided.")
    private List<Long> candidateIds;
}
