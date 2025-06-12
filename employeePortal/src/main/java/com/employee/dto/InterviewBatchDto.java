package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewBatchDto {

        private Long id;

        @NotNull(message = "Interview date is required.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate interviewDate;

        @NullOrNotBlank(min = 5, max = 20, message = "Time slot is required and must be between {min} and {max} characters.")
        private String timeSlot;

        @NotNull(message = "Position ID is required.")
        private Long positionId;

        @NotEmpty(message = "At least one candidate must be assigned.")
        private List<Long> candidateIds;
}
