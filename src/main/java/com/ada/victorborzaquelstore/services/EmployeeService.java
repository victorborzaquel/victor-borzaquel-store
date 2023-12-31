package com.ada.victorborzaquelstore.services;

import com.ada.victorborzaquelstore.modules.employee.dto.CreateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.ResponseEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.UpdateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.employee.DepartmentType;
import com.ada.victorborzaquelstore.modules.employee.EmployeeRole;
import com.ada.victorborzaquelstore.shared.exceptions.EmployeeNotFoundException;
import com.ada.victorborzaquelstore.modules.employee.EmployeeMapper;
import com.ada.victorborzaquelstore.repositories.EmployeeDslRepository;
import com.ada.victorborzaquelstore.repositories.EmployeeRepository;
import com.ada.victorborzaquelstore.modules.user.UserEntity;
import com.ada.victorborzaquelstore.modules.user.UserRole;
import com.ada.victorborzaquelstore.modules.user.UserMapper;
import com.ada.victorborzaquelstore.shared.exceptions.base.AlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeDslRepository employeeDslRepository;
  private final PasswordEncoder passwordEncoder;

  private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  public EmployeeEntity findByUsername(String username) {
    return this.employeeRepository.findByUserUsername(username).orElseThrow(EmployeeNotFoundException::new);
  }

  public ResponseEmployeeDTO create(CreateEmployeeDTO dto) {
    this.checkForDuplicateUniqueFields(dto);

    EmployeeEntity employee = this.employeeMapper.toEntity(dto);
    UserEntity user = this.userMapper.toEntity(dto);

    user.setPasswordHash(this.passwordEncoder.encode(dto.getPassword()));
    employee.setUser(user);
    user.setRole(UserRole.EMPLOYEE);

    EmployeeEntity response = this.employeeRepository.save(employee);
    return this.employeeMapper.toResponse(response);
  }

  public ResponseEmployeeDTO update(UUID id, UpdateEmployeeDTO dto) {
    this.checkForDuplicateUniqueFields(id, dto);

    EmployeeEntity employee = this.employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

    this.userMapper.updateFromDto(employee.getUser(), dto);

    EmployeeEntity response = this.employeeRepository.save(employee);
    return this.employeeMapper.toResponse(response);
  }

  public ResponseEmployeeDTO getOne(UUID id) {
    EmployeeEntity employee = this.employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    return this.employeeMapper.toResponse(employee);
  }

  public Page<ResponseEmployeeDTO> getAll(Pageable pageable) {
    Page<EmployeeEntity> employees = this.employeeRepository.findAll(pageable);
    return employees.map(this.employeeMapper::toResponse);
  }

  public List<EmployeeEntity> getAllSalesManagers() {
    return this.employeeRepository.findAllByDepartmentAndAndRole(DepartmentType.SALES, EmployeeRole.MANAGER);
  }

  public void delete(UUID id) {
    this.employeeRepository.deleteById(id);
  }

  private void checkForDuplicateUniqueFields(CreateEmployeeDTO dto) {
    List<String> errors = new ArrayList<>();

    if (employeeDslRepository.existsByUserEmail(dto.getEmail())) {
      errors.add("Email already exists");
    }

    if (employeeDslRepository.existsByUserUsername(dto.getUsername())) {
      errors.add("Username already exists");
    }

    if (employeeDslRepository.existsByUserCpf(dto.getCpf())) {
      errors.add("CPF already exists");
    }

    if (!errors.isEmpty()) {
      throw new AlreadyExistsException(errors, "Employee already exists");
    }
  }

  private void checkForDuplicateUniqueFields(UUID id, UpdateEmployeeDTO dto) {
    List<String> errors = new ArrayList<>();

    if (employeeDslRepository.existsByUserEmail(dto.getEmail(), id)) {
      errors.add("Email already exists");
    }

    if (!errors.isEmpty()) {
      throw new AlreadyExistsException(errors, "Employee already exists");
    }
  }
}
