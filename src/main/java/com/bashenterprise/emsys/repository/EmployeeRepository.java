package com.bashenterprise.emsys.repository;

import com.bashenterprise.emsys.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
