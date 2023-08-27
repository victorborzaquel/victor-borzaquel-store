package com.ada.victorborzaquelstore.shared.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class AlreadyExistsException extends AppException {

  public AlreadyExistsException(List<String> errors, String reason) {
    super(
        errors,
        HttpStatus.CONFLICT,
        reason != null ? reason : "Already exists"
    );
  }

  public AlreadyExistsException(String reason) {
    this(null, reason);
  }
}
