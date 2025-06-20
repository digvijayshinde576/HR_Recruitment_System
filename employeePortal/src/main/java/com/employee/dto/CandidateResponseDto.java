package com.employee.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateResponseDto {

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    private List<PositionResponseDto> positions;
}
