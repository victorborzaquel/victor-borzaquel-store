package com.ada.victorborzaquelstore.modules.client.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientDTO {

  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid first name")
  @NotEmpty(message = "First name is required")
  private String firstName;

  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid last name")
  @NotEmpty(message = "Last name is required")
  private String lastName;

  @Email(message = "Invalid email")
  @NotEmpty(message = "Email is required")
  private String email;

}
