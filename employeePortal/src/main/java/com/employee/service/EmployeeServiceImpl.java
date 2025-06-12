package com.employee.service;
import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.repository.EmployeeRepository;
import com.employee.util.MapperUtil;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MapperUtil mapperUtil;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, MapperUtil mapperUtil) {
        this.employeeRepository = employeeRepository;
        this.mapperUtil = mapperUtil;
    }

    public EmployeeEntity addEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(mapperUtil.mapObject(employeeDto, EmployeeEntity.class));

    }

    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();

    }

    public Optional<EmployeeEntity> getEmployeeById(Long id) {
      return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Employee Id")));
    }

    public void deleteEmployeeById(Long id) {
        if(!employeeRepository.existsById(id)){
          throw new RuntimeException("Invalid Employee Id");
        }else employeeRepository.deleteById(id);
    }

}