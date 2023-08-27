package com.ada.victorborzaquelstore.shared.exceptions.base;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends AppException {

  public UnauthorizedException(String reason) {
    super(
        HttpStatus.UNAUTHORIZED,
        reason != null ? reason : "Unauthorized"
    );
  }

  public UnauthorizedException() {
    this(null);
  }
}
