package com.employee.service;


import com.employee.dto.*;
import com.employee.entity.Company;
import com.employee.entity.Department;
import com.employee.mapper.CompanyMapper;
import com.employee.repository.CompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@Service
//@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final ObjectMapper objectMapper;
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(ObjectMapper objectMapper, CompanyMapper companyMapper, CompanyRepository companyRepository) {
        this.objectMapper = objectMapper;
        this.companyMapper = companyMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyResponseDto create(CompanyDto dto) {
        Company company = companyMapper.companyDtoToCompanyEntity(dto);
        return companyMapper.companyToCompanyResponseDto( companyRepository.save(company));
    }

    @Override
    public List<CompanyResponseDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companyMapper.listCompanyToCompanyResponseDto(companies);
    }


    @Override
    public CompanyResponseDto getById(Long id) {
        return companyMapper.companyToCompanyResponseDto(companyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Company not found with ID: " + id)));
    }

    public JsonNode getJsonNode(String jsonString) {
        try {
            return objectMapper.readTree(jsonString);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T readValue(String content, Class<T> targetClass) {
        try {
            return objectMapper.readValue(content, targetClass);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public CompanyResponseDto update(Long id, String updatedDto) {

        Company companyFieldToUpdate = Optional.ofNullable(readValue(updatedDto, Company.class))
                .orElseThrow(() -> new RuntimeException("Invalid Company request payload"));

        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with Id : " + id));

        JsonNode jsonNode = getJsonNode(updatedDto);
        if (jsonNode.has("name")) {
            int length = companyFieldToUpdate.getName().length();
            if (!(length >= 1 && length <= 50)) {
                throw new RuntimeException("Name is required and must be between 1 and 50 characters");
            }
            existingCompany.setName(companyFieldToUpdate.getName());
        }
        if (jsonNode.has("address")) {
            int length = companyFieldToUpdate.getAddress().length();
            if (!(length >= 1 && length <= 50)) {
                throw new RuntimeException("Address is required and  must be between 1 and 50 characters");
            }
            existingCompany.setAddress(companyFieldToUpdate.getAddress());
        }
        if (jsonNode.has("website")) {
            int length = companyFieldToUpdate.getAddress().length();
            if (!(length >= 2 && length <= 100)) {
                throw new RuntimeException("Website is required and  must be between 2 and 100 characters");
            }
            existingCompany.setAddress(companyFieldToUpdate.getAddress());
        }
        if (jsonNode.has("industry")) {
            int length = companyFieldToUpdate.getAddress().length();
            if (!(length >= 2 && length <= 100)) {
                throw new RuntimeException("industry is required and  must 50 characters");
            }
            existingCompany.setAddress(companyFieldToUpdate.getAddress());
        }
        return companyMapper.companyToCompanyResponseDto(companyRepository.save(existingCompany));
    }

    public void delete(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Company not found with ID: " + id));
        company.getDepartment().clear();
       // company.getEmployee().clear();

        companyRepository.delete(company);
    }
}
