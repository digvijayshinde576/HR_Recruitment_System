package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewerDto {
        private Long id;
        private String name;
        private String email;
        private String department;
        private String jobTitle;
        private List<Long> applicationIds;

}
