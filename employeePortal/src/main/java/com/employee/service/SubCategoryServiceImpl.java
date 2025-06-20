package com.employee.service;


import com.employee.dto.SubCategoryDto;
import com.employee.dto.SubCategoryResponseDto;
import com.employee.entity.Department;
import com.employee.entity.SubCategory;
import com.employee.mapper.SubCategoryMapper;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.SubCategoryRepository;
import com.employee.service.SubCategoryService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.employee.util.UpdateUtil.getJsonNode;
import static com.employee.util.UpdateUtil.readValue;


@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final DepartmentRepository departmentRepository;
    private final SubCategoryMapper subCategoryMapper;

    @Override
    public SubCategoryResponseDto create(SubCategoryDto dto) {
        SubCategory subCategory = subCategoryMapper.subCategoryDtoToSubCategory(dto);
        return subCategoryMapper.subCategoryToSubCategoryResponseDto(subCategoryRepository.save(subCategory));
    }

    @Override
    public List<SubCategoryResponseDto> getAll() {
        return subCategoryRepository.findAll().stream().map(subCategoryMapper::subCategoryToSubCategoryResponseDto).collect(Collectors.toList());
    }

    @Override
    public SubCategoryResponseDto getById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("SubCategory not found with ID: " + id));
        return subCategoryMapper.subCategoryToSubCategoryResponseDto(subCategory);
    }

    @Override
    public SubCategoryResponseDto update(Long id, String subCategoryDtoJson) {
        SubCategory existing = subCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("SubCategory not found with ID: " + id));
        SubCategoryDto updatedFields = readValue(subCategoryDtoJson, SubCategoryDto.class);
        JsonNode jsonNode = getJsonNode(subCategoryDtoJson);
        if (jsonNode.has("name")) {
            String name = updatedFields.getName();
            if (name == null || name.length() < 2 || name.length() > 100) {
                throw new RuntimeException("Name must be between 2 and 100 characters.");
            }
            existing.setName(name);
        }
        if (jsonNode.has("departmentId")) {
            Long departmentId = updatedFields.getDepartmentId();
            Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department ID not found."));
            existing.setDepartment(department);
        }
        return subCategoryMapper.subCategoryToSubCategoryResponseDto(subCategoryRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("SubCategory not found with ID: " + id));
        subCategoryRepository.delete(subCategory);
    }
}