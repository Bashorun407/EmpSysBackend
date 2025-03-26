package com.bashenterprise.emsys.service.Impl;

import com.bashenterprise.emsys.dto.EmployeeDto;
import com.bashenterprise.emsys.entity.Employee;
import com.bashenterprise.emsys.mapper.EmployeeMapper;
import com.bashenterprise.emsys.repository.EmployeeRepository;
import com.bashenterprise.emsys.service.EmployeeService;
import org.springframework.stereotype.Service;

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
}
