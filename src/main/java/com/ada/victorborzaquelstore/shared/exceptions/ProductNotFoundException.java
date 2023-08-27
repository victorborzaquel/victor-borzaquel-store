package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.NotFoundException;

public class ProductNotFoundException extends NotFoundException {

  public ProductNotFoundException() {
    super("Product not found");
  }

}
