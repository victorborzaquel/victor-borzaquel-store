package com.ada.victorborzaquelstore.modules.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductDTO {
  private String title;
  private String description;
  private Double price;
  private Integer stock;
}
