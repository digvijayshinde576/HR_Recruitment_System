package com.employee.service;

import com.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto addEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployee();
}
