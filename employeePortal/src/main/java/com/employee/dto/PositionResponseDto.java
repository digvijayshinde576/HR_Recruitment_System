package com.employee.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionResponseDto {

    private Long id;
    private String positionName;

}
