package com.ada.victorborzaquelstore.shared.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException {

  public NotFoundException(String reason) {
    super(HttpStatus.NOT_FOUND, reason != null ? reason : "Entity not found");
  }

}
