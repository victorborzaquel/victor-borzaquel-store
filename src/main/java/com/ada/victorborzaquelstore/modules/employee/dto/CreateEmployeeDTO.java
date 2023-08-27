package com.ada.victorborzaquelstore.modules.employee.dto;

import com.ada.victorborzaquelstore.modules.employee.DepartmentType;
import com.ada.victorborzaquelstore.modules.employee.EmployeeRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDTO {
  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid first name")
  @NotEmpty(message = "First name is required")
  private String firstName;

  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid last name")
  @NotEmpty(message = "Last name is required")
  private String lastName;

  @Email(message = "Invalid email")
  @NotEmpty(message = "Email is required")
  private String email;

  @NotEmpty(message = "Password is required")
  @Pattern(
      regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
      message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character"
  )
  private String password;

  @CPF(message = "Invalid CPF")
  @NotEmpty(message = "CPF is required")
  private String cpf;

  @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid username")
  @NotEmpty(message = "Username is required")
  private String username;

  @NotNull(message = "Department is required")
  private DepartmentType department;

  @NotNull(message = "Role is required")
  private EmployeeRole role;
}
