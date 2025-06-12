package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
     EmployeeEntity addEmployee(EmployeeDto employeeDto);
     List<EmployeeEntity> getAllEmployee();
     Optional<EmployeeEntity> getEmployeeById(Long id);
     void deleteEmployeeById(Long id);
}
