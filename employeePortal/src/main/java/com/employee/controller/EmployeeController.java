package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> create(@Valid  @RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(employeeService.addEmployee(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAll() {
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }

     @GetMapping("{/id}")
    public ResponseEntity<Optional<EmployeeEntity>> getEmployeeById(@PathVariable (name = "id") Long id) {
       return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);

    }
    @DeleteMapping("{/id}")
    public ResponseEntity<?> deleteemployeeById(@PathVariable (name = "id") Long id){
        try {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok("Employee deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
