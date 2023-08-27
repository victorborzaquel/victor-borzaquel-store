package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.NotFoundException;

public class EmployeeNotFoundException extends NotFoundException {
  public EmployeeNotFoundException() {
    super("Employee not found");
  }
}
