package com.ada.victorborzaquelstore.modules.product.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDTO {
  private UUID id;
  private String title;
  private String description;
  private BigDecimal price;
  private BigDecimal discountPercentage;
  private Double rating;
  private Integer stock;
  private String brand;
  private String category;
  private String thumbnail;
  private List<String> images;
  private BigDecimal discountPrice;
  private BigDecimal totalPrice;
}
