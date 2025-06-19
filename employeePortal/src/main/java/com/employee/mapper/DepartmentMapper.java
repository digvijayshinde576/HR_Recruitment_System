package com.employee.mapper;


import com.employee.dto.DepartmentDto;
import com.employee.dto.DepartmentResponseDto;
import com.employee.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SubCategoryMapper.class)
public interface DepartmentMapper {

    @Mapping(source = "companyId", target = "company.id")
    Department deptDtoToDepartment(DepartmentDto departmentDto);

    DepartmentResponseDto departmentToDepartmentDto(Department department);

}

