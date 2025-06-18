package com.employee.mapper;


import com.employee.dto.DepartmentDto;
import com.employee.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SubCategoryMapper.class)
public interface DepartmentMapper {

    @Mapping(source = "subCategories", target = "subCategories")
    Department deptDtoToDepartment(DepartmentDto departmentDto);
}

