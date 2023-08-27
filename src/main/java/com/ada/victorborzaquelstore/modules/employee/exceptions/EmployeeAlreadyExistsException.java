package com.ada.victorborzaquelstore.modules.employee.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.AlreadyExistsException;

public class EmployeeAlreadyExistsException extends AlreadyExistsException {
  public EmployeeAlreadyExistsException() {
    super("Employee already exists");
  }
}
