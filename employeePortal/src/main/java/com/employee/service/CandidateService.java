package com.employee.service;

import com.employee.dto.CandidateProjection;
import com.employee.dto.CandidateRequestDto;
import com.employee.dto.CandidateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidateService {

    CandidateResponseDto create(CandidateRequestDto dto);

    Page<CandidateProjection> getAll(Pageable pageable);

    CandidateResponseDto getById(Long id);

    CandidateResponseDto update(Long id, String json);

    void delete(Long id);
}
    