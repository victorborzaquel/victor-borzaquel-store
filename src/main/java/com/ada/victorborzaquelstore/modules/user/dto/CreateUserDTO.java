package com.ada.victorborzaquelstore.modules.user.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
  private String name;
  private String email;
  private String cpf;
}
