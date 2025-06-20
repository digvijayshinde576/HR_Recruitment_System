package com.employee.dto;

import com.employee.entity.Position;

import java.time.LocalDate;
import java.util.List;

public interface CandidateProjection {
    Long getId();
    String getName();
    String getEmail();
    LocalDate getDob();
    List<Position> getPositions();
}
