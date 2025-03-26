package com.bashenterprise.emsys.mapper;

//import com.bashenterprise.emsys.dto.EmployeeDto;
import com.bashenterprise.emsys.dto.EmployeeDto;
import com.bashenterprise.emsys.dto.EmployeeRecDto;
import com.bashenterprise.emsys.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
//
//    public static Employee mapToEmployee(EmployeeDto employeeDto){
//        return new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );
//    }

    public static EmployeeRecDto mapToEmployeeRecDto(Employee employee){
        return new EmployeeRecDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeRecDto employeeRecDto){
        return new Employee(
                employeeRecDto.id(),
                employeeRecDto.firstName(),
                employeeRecDto.lastName(),
                employeeRecDto.email()
        );
    }
}
