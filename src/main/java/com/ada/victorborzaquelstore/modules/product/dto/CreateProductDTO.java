package com.ada.victorborzaquelstore.modules.product.dto;

import jakarta.validation.constraints.Pattern;
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
public class CreateProductDTO {
  private String title;
  private String description;
  private BigDecimal price;
  private BigDecimal discountPercentage;
  private Integer stock;
  private String brand;
  private String category;
  private String thumbnail;
  private List<String> images;
}
