package com.bashenterprise.emsys.service;

import com.bashenterprise.emsys.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
}
