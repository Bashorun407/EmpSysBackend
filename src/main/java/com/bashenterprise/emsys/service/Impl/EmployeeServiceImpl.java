package com.bashenterprise.emsys.service.Impl;

import com.bashenterprise.emsys.dto.EmployeeDto;
import com.bashenterprise.emsys.entity.Employee;
import com.bashenterprise.emsys.exception.ResourceNotFoundException;
import com.bashenterprise.emsys.mapper.EmployeeMapper;
import com.bashenterprise.emsys.repository.EmployeeRepository;
import com.bashenterprise.emsys.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
       Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with " +
                                "given id does not exist : " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee with this id does not exist: " + id));
        employee.setFirstName(employeeDto.firstName());
        employee.setLastName(employeeDto.lastName());
        employee.setEmail(employeeDto.email());

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
