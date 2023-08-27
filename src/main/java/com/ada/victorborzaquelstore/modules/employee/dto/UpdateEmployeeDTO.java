package com.ada.victorborzaquelstore.modules.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDTO {
  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid first name")
  private String firstName;

  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid last name")
  private String lastName;

  @Email(message = "Invalid email")
  private String email;
}
