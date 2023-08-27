package com.ada.victorborzaquelstore.modules.order.entities;

import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderEntity order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;

  @Column(name = "quantity")
  private Integer quantity;

  public BigDecimal getPrice() {
    return multiplyByQuantity(product.getPrice());
  }

  public BigDecimal getTotalPrice() {
    return multiplyByQuantity(product.getTotalPrice());
  }

  public BigDecimal getDiscountPrice() {
    return multiplyByQuantity(product.getDiscountPrice());
  }

  private BigDecimal multiplyByQuantity(BigDecimal value) {
    return value.multiply(BigDecimal.valueOf(quantity));
  }

}
