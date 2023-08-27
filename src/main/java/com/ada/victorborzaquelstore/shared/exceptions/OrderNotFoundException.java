package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.NotFoundException;

public class OrderNotFoundException extends NotFoundException {
  public OrderNotFoundException() {
    super("Order not found");
  }
}
