package com.employee.service;

import com.employee.dto.DepartmentDto;
import com.employee.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto create(DepartmentDto dto);

    List<DepartmentResponseDto> getAll();

    DepartmentResponseDto getById(Long id);

    DepartmentResponseDto update(Long id, String dtoJson);

    void delete(Long id);}
