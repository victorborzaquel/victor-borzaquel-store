package com.ada.victorborzaquelstore.integrations.dummyjson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DummyJsonProductDTO {
  private Long id;
  private String title;
  private String description;
  private BigDecimal price;
  private BigDecimal discountPercentage;
  private BigDecimal rating;
  private Integer stock;
  private String brand;
  private String category;
  private String thumbnail;
  private List<String> images;
}
