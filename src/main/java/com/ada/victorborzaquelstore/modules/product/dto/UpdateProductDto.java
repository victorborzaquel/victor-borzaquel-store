package com.ada.victorborzaquelstore.modules.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateProductDto {
  private String title;
  private String description;
  private Double price;
}
