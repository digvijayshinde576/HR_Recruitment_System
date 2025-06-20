package com.employee.mapper;

import com.employee.dto.*;
import com.employee.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    @Mapping(source = "departmentId", target = "department.id")
    SubCategory subCategoryDtoToSubCategory(SubCategoryDto subCategoryDto);

    @Mapping(source = "employee", target = "employeeResponseDtos")
    SubCategoryResponseDto subCategoryToSubCategoryResponseDto(SubCategory subCategory);
}