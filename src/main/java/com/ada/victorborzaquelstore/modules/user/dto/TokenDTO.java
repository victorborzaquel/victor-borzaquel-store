package com.ada.victorborzaquelstore.modules.user.dto;

import com.ada.victorborzaquelstore.infra.security.TokenType;
import lombok.Data;

@Data
public class TokenDTO {
  private final TokenType type;
  private final String token;

  public TokenDTO(String token) {
    this.token = token;
    this.type = TokenType.BEARER;

  }

  public TokenDTO(String token, TokenType type) {
    this.token = token;
    this.type = type;
  }
}
