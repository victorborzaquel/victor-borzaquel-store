package com.ada.victorborzaquelstore.modules.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateUserDto {
  private String name;
  private String email;
  private String cpf;
}
