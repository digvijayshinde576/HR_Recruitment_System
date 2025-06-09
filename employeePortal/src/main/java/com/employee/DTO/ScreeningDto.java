package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDto {
        private Long id;
        private Long candidateCVId;
        private String screeningResult;
        private String rejectionReason;

}
