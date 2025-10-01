package com.kgonzaga.soap_server.app.service;

import com.kgonzaga.soap_server.app.presentation.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee dto);

    Optional<Employee> getEmployeeById(Long id);

    Optional<Employee> updateEmployee(Long id, Employee dto);

    Boolean deleteEmployee(Long id);
}
