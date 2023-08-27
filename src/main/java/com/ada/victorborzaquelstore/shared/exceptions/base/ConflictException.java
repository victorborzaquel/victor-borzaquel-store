package com.ada.victorborzaquelstore.shared.exceptions.base;

import org.springframework.http.HttpStatus;

public class ConflictException extends AppException {

  public ConflictException(String reason) {
    super(HttpStatus.CONFLICT, reason != null ? reason : "Conflict in the application");
  }

  public ConflictException() {
    this(null);
  }

}
