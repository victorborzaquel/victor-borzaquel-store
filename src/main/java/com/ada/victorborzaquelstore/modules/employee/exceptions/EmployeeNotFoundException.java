package com.ada.victorborzaquelstore.modules.employee.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.NotFoundException;

public class EmployeeNotFoundException extends NotFoundException {
  public EmployeeNotFoundException() {
    super("Employee not found");
  }
}
