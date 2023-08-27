package com.ada.victorborzaquelstore.modules.employee.repositories;

import com.ada.victorborzaquelstore.modules.employee.entities.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.employee.enums.DepartmentType;
import com.ada.victorborzaquelstore.modules.employee.enums.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
  Optional<EmployeeEntity> findAllByDepartmentAndAndRole(DepartmentType department, EmployeeRole role);
}
