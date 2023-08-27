package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.AlreadyExistsException;

public class EmployeeAlreadyExistsException extends AlreadyExistsException {
  public EmployeeAlreadyExistsException() {
    super("Employee already exists");
  }
}
