package com.employee.mapper;



import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;
import com.employee.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface CompanyMapper {


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "industry", target = "industry"),
            @Mapping(source = "website", target = "website"),
    })
    Company companyDtoToCompanyEntity(CompanyDto dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "industry", target = "industry")
    @Mapping(source = "website", target = "website")
    CompanyResponseDto companyToCompanyResponseDto(Company entity);


}

