package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.entity.Employee;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    // private final MapperUtil mapperUtil;
    private final EmployeeMapper employeeMapper;


    public EmployeeResponseDto addEmployee(EmployeeDto employeeDto) {
        System.out.println(employeeDto);
        Employee employee = employeeRepository.save(employeeMapper.dtoToEntity(employeeDto));
        return employeeMapper.entityToDto(employee);


    }

    public List<EmployeeResponseDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employeeMapper::entityToDto).collect(Collectors.toList());

    }

    public Optional<EmployeeResponseDto> getEmployeeById(Long id) {
        return Optional.ofNullable(employeeMapper.entityToDto((employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Employee Id")))));

    }

    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Invalid Employee Id");
        } else employeeRepository.deleteById(id);
    }

}