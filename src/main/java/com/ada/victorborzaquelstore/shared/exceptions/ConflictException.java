package com.ada.victorborzaquelstore.shared.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends AppException {

  public ConflictException(String reason) {
    super(HttpStatus.CONFLICT, reason != null ? reason : "Conflict in the application");
  }

}
