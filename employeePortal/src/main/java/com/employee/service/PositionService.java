package com.employee.service;

import com.employee.dto.PositionProjection;
import com.employee.dto.PositionRequestDto;
import com.employee.dto.PositionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PositionService {

    PositionResponseDto create(PositionRequestDto dto);

    Page<PositionProjection> getAll(Pageable pageable);

    PositionResponseDto getById(Long id);

    PositionResponseDto update(Long id, String json);

//    void delete(Long id);
}
