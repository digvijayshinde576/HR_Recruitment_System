package com.employee.controller;

import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;
import com.employee.dto.RestApiResponse;
import com.employee.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<RestApiResponse<CompanyResponseDto>> create(@Valid @RequestBody CompanyDto dto) {
        CompanyResponseDto created = companyService.create(dto);
        RestApiResponse<CompanyResponseDto> response = RestApiResponse.<CompanyResponseDto>builder()
                .message("Company Created Successfully...")
                .data(created)
                .timestamp(new Date())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<RestApiResponse<List<CompanyResponseDto>>> getAll() {
        List<CompanyResponseDto> companies = companyService.getAll();
        return ResponseEntity.ok(RestApiResponse.<List<CompanyResponseDto>>builder()
                .message("All Companies Fetched Successfully...")
                .data(companies)
                .timestamp(new Date())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<Optional<CompanyResponseDto>>> getById(@PathVariable Long id) {
        Optional<CompanyResponseDto> company = Optional.ofNullable(companyService.getById(id));
        return ResponseEntity.ok(RestApiResponse.<Optional<CompanyResponseDto>>builder()
                .message("Company Fetched Successfully...")
                .data(company)
                .timestamp(new Date())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestApiResponse<CompanyResponseDto>> update(@PathVariable Long id, @RequestBody String companyDtoJson) {
        CompanyResponseDto updated = companyService.update(id, companyDtoJson);
        RestApiResponse<CompanyResponseDto> response = RestApiResponse.<CompanyResponseDto>builder()
                .message("Company Updated Successfully...")
                .data(updated)
                .timestamp(new Date())
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestApiResponse<Object>> delete(@PathVariable Long id) {
        companyService.delete(id);
        return ResponseEntity.ok(RestApiResponse.builder()
                .message("Company Deleted Successfully...")
                .timestamp(new Date())
                .build());
    }
}
