package com.ada.victorborzaquelstore.infra.security;

import lombok.Getter;

@Getter
public enum TokenType {
  BEARER("Bearer");

  private final String type;

  TokenType(String type) {
    this.type = type;
  }

}
