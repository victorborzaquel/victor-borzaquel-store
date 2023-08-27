package com.ada.victorborzaquelstore.repositories;

import com.ada.victorborzaquelstore.modules.employee.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.employee.DepartmentType;
import com.ada.victorborzaquelstore.modules.employee.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
  Optional<EmployeeEntity> findByUserUsername(String username);

  List<EmployeeEntity> findAllByDepartmentAndAndRole(DepartmentType department, EmployeeRole role);
}
