package com.ada.victorborzaquelstore.modules.product.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.NotFoundException;

public class ProductNotFoundException extends NotFoundException {

  public ProductNotFoundException() {
    super("Product not found");
  }

}
