package com.ada.victorborzaquelstore.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseUserDto {
  private UUID id;
  private String name;
  private String email;
  private String cpf;
}
