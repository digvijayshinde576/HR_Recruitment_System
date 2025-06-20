package com.employee.dto;

import com.employee.annotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionRequestDto {

    @NullOrNotBlank(min = 2, max = 100, isMandatory = "yes", message = "Position title is required and must be between {min} and {max} characters.")
    private String positionName;

}
