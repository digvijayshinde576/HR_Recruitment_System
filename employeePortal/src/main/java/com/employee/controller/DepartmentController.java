package com.employee.controller;

import com.employee.dto.DepartmentDto;
import com.employee.dto.DepartmentResponseDto;
import com.employee.dto.RestApiResponse;
import com.employee.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<RestApiResponse<DepartmentResponseDto>> create(@Valid @RequestBody DepartmentDto dto) {
        DepartmentResponseDto created = departmentService.create(dto);
        RestApiResponse<DepartmentResponseDto> response = RestApiResponse.<DepartmentResponseDto>builder().message("Department Created Successfully...").data(created).timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<RestApiResponse<List<DepartmentResponseDto>>> getAll() {
        List<DepartmentResponseDto> departments = departmentService.getAll();
        return ResponseEntity.ok(RestApiResponse.<List<DepartmentResponseDto>>builder().message("All Departments Fetched Successfully...").data(departments).timestamp(new Date()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<Optional<DepartmentResponseDto>>> getById(@PathVariable Long id) {
        Optional<DepartmentResponseDto> department = Optional.ofNullable(departmentService.getById(id));
        return ResponseEntity.ok(RestApiResponse.<Optional<DepartmentResponseDto>>builder().message("Department Fetched Successfully...").data(department).timestamp(new Date()).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestApiResponse<DepartmentResponseDto>> updateDepartment(@PathVariable Long id, @RequestBody String departmentDtoJson) {

        DepartmentResponseDto updated = departmentService.update(id, departmentDtoJson);

        RestApiResponse<DepartmentResponseDto> response = RestApiResponse.<DepartmentResponseDto>builder().message("Department Updated Successfully...").data(updated).timestamp(new Date()).build();

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<RestApiResponse<Object>> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok(RestApiResponse.builder().message("Department Deleted Successfully...").timestamp(new Date()).build());
    }
}
