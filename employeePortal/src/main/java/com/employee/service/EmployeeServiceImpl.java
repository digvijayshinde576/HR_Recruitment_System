package com.employee.service;

import com.employee.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    Map<Long, EmployeeDto> employeeList=new HashMap<>();
    Long id=1L;
    public EmployeeDto addEmployee(EmployeeDto employeeDto){
        employeeDto.setId(id);
        employeeList.put(id,employeeDto);
        return employeeDto;

    }

    public List<EmployeeDto> getAllEmployee(){
        return (List<EmployeeDto>) employeeList;

    }

}