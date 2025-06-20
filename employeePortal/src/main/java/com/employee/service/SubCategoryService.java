package com.employee.service;

import com.employee.dto.SubCategoryDto;
import com.employee.dto.SubCategoryResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface SubCategoryService {
    SubCategoryResponseDto create(@Valid SubCategoryDto dto);

    List<SubCategoryResponseDto> getAll();

    SubCategoryResponseDto getById(Long id);

    SubCategoryResponseDto update(Long id, String subCategoryDtoJson);

    void delete(Long id);
}