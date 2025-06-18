package com.employee.service;

import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;

import java.util.List;

public interface CompanyService {

    CompanyResponseDto create(CompanyDto dto);

    List<CompanyResponseDto> getAll();

    CompanyResponseDto getById(Long id);

    CompanyResponseDto update(Long id, String updatedDto);

    void delete(Long id);
}
