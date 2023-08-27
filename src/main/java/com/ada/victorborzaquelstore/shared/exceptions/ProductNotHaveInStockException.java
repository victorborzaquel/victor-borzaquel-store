package com.ada.victorborzaquelstore.shared.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.base.ConflictException;

public class ProductNotHaveInStockException extends ConflictException {

  public ProductNotHaveInStockException() {
    super("Product not have in stock");
  }

}
