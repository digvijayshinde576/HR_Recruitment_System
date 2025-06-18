package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponseDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
     EmployeeResponseDto addEmployee(EmployeeDto employeeDto);
     List<EmployeeResponseDto > getAllEmployee();
     Optional<EmployeeResponseDto > getEmployeeById(Long id);
     void deleteEmployeeById(Long id);
}
