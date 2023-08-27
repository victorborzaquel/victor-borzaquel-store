package com.ada.victorborzaquelstore.modules.order.dto;

import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrderItemDTO {
  private UUID id;
  private ProductEntity product;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal discountPrice;
  private BigDecimal totalPrice;
}
