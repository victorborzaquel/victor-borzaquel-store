package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.ConflictException;

public class OrderIsNotOpenException extends ConflictException {
  public OrderIsNotOpenException() {
    super("Order already open");
  }
}
