package com.kgonzaga.soap_server.app.persistence.repository;

import com.kgonzaga.soap_server.app.persistence.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
}
