package com.kgonzaga.soap_server.app.mapper;

import com.kgonzaga.soap_server.app.persistence.entity.EmployeeEntity;
import com.kgonzaga.soap_server.app.presentation.dto.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeEntity dtoToEntity(Employee dto) {
        var entity = new EmployeeEntity();
        if (dto.getId() != 0) {
            entity.setId(dto.getId());
        }
        entity.setName(dto.getName());
        entity.setJob(dto.getJob());
        entity.setSalary(dto.getSalary());

        return entity;
    }

    public Employee entityToDto(EmployeeEntity entity) {
        var dto = new Employee();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setJob(entity.getJob());
        dto.setSalary(entity.getSalary());
        return dto;
    }
}
