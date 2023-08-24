package com.ada.victorborzaquelstore.modules.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseProductDto {
  private UUID id;
  private String title;
  private String description;
  private Double price;
  private Integer stock;
}
