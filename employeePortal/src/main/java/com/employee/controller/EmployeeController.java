package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.dto.RestApiResponse;
import com.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<RestApiResponse<EmployeeResponseDto>> create(@Valid @RequestBody EmployeeDto dto) {
        EmployeeResponseDto savedEmployee = employeeService.addEmployee(dto);

        RestApiResponse<EmployeeResponseDto> response = RestApiResponse.<EmployeeResponseDto>builder().message("Employee Created Successfully...").data(savedEmployee).timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<RestApiResponse<List<EmployeeResponseDto>>> getAll() {
        List<EmployeeResponseDto> allEmployee = employeeService.getAllEmployee();
        return ResponseEntity.ok(RestApiResponse.<List<EmployeeResponseDto>>builder().message("All Employee Fetched Successfully.....").data(allEmployee).timestamp(new Date()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<Optional<EmployeeResponseDto>>> getEmployeeById(@PathVariable(name = "id") Long id) {
        Optional<EmployeeResponseDto> employeeById = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(RestApiResponse.<Optional<EmployeeResponseDto>>builder().message("Employee Fetched Successfully.....").data(employeeById).timestamp(new Date()).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestApiResponse<Object>> deleteemployeeById(@PathVariable(name = "id") Long id) {

        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(RestApiResponse.builder().message("Employee Deleted Succesfully......").build());
    }
}
