package com.ada.victorborzaquelstore.modules.employee.dto;

import com.ada.victorborzaquelstore.modules.employee.enums.DepartmentType;
import com.ada.victorborzaquelstore.modules.employee.enums.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEmployeeDTO {
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String cpf;
  private String username;
  private DepartmentType department;
  private EmployeeRole role;
}
