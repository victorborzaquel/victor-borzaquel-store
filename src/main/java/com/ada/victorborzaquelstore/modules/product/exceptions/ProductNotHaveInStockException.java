package com.ada.victorborzaquelstore.modules.product.exceptions;

import com.ada.victorborzaquelstore.shared.exceptions.ConflictException;

public class ProductNotHaveInStockException extends ConflictException {

  public ProductNotHaveInStockException() {
    super("Product not have in stock");
  }

}
