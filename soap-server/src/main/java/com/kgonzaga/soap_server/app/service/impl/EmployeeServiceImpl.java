package com.kgonzaga.soap_server.app.service.impl;

import com.kgonzaga.soap_server.app.mapper.EmployeeMapper;
import com.kgonzaga.soap_server.app.persistence.repository.EmployeeRepository;
import com.kgonzaga.soap_server.app.presentation.dto.Employee;
import com.kgonzaga.soap_server.app.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployees() {
        return StreamSupport.stream(this.repository.findAll().spliterator(), false)
                .map(mapper::entityToDto)
                .toList();
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee dto) {
        var employeeEntity = this.repository.save(mapper.dtoToEntity(dto));
        return mapper.entityToDto(employeeEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::entityToDto);
    }

    @Transactional
    @Override
    public Optional<Employee> updateEmployee(Long id, Employee dto) {
        return this.repository.findById(id).map(entity -> {
            entity.setName(dto.getName());
            entity.setJob(dto.getJob());
            entity.setSalary(dto.getSalary());
            var updated = this.repository.save(entity);
            return this.mapper.entityToDto(updated);
        });
    }

    @Transactional
    @Override
    public Boolean deleteEmployee(Long id) {
        return this.repository.findById(id).map(entity -> {
            this.repository.delete(entity);
            return true;
        }).orElse(false);
    }
}
