package com.ada.victorborzaquelstore.modules.order_item;

import com.ada.victorborzaquelstore.modules.order.OrderEntity;
import com.ada.victorborzaquelstore.modules.product.ProductEntity;
import jakarta.persistence.*;

import java.util.UUID;

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
  private ProductEntity product;
}
