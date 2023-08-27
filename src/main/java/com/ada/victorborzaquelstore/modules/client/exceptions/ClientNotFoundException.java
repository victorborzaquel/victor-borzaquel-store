package com.ada.victorborzaquelstore.modules.client.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.NotFoundException;

public class ClientNotFoundException extends NotFoundException {
  public ClientNotFoundException() {
    super("Client not found");
  }
}
