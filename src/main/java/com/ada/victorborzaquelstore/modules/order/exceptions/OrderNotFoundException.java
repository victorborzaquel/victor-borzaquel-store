package com.ada.victorborzaquelstore.modules.order.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.NotFoundException;

public class OrderNotFoundException extends NotFoundException {
  public OrderNotFoundException() {
    super("Order not found");
  }
}
