package com.employee.mapper;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.entity.Company;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.entity.SubCategory;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
//            @Mapping(source = "companyId", target = "company.id"),
            @Mapping(source = "departmentId", target = "department.id"),
            @Mapping(source = "subCategoryId", target = "subCategory.id")
    })
    Employee dtoToEntity(EmployeeDto dto);

    @Mappings({
//            @Mapping(source = "company.id", target = "companyId"),
            @Mapping(source = "department.id", target = "departmentId"),
            @Mapping(source = "subCategory.id", target = "subCategoryId")
    })
    EmployeeResponseDto entityToDto(Employee employee);
}
