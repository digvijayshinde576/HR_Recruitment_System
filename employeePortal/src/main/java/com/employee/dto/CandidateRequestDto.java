package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateRequestDto {

    @NullOrNotBlank(min = 2, max = 100, isMandatory = "yes", message = "Name is required and must be between {min} and {max} characters.")
    private String name;

    @NullOrNotBlank(isMandatory = "yes", min = 5, max = 100, message = "Email is required and must be valid.")
    private String email;

    @NotNull(message = "Date of birth is mandatory.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;


    private List<Long> positionIds;


}
