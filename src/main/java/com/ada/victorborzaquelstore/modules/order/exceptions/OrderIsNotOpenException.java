package com.ada.victorborzaquelstore.modules.order.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.ConflictException;

public class OrderIsNotOpenException extends ConflictException {
  public OrderIsNotOpenException() {
    super("Order already open");
  }
}
