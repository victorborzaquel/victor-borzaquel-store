package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.NotFoundException;

public class ClientNotFoundException extends NotFoundException {
  public ClientNotFoundException() {
    super("Client not found");
  }
}
