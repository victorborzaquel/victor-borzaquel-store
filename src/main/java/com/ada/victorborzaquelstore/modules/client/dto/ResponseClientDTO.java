package com.ada.victorborzaquelstore.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClientDTO {

  private UUID id;
  private String username;
  private String firstName;
  private String lastName;
  private String cpf;
  private String email;

}
