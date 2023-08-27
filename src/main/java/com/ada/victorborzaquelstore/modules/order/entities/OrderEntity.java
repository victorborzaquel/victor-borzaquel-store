package com.ada.victorborzaquelstore.modules.order.entities;

import com.ada.victorborzaquelstore.modules.address.entities.AddressEntity;
import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import com.ada.victorborzaquelstore.modules.order.enums.OrderStatus;
import com.ada.victorborzaquelstore.modules.order.exceptions.OrderIsNotOpenException;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private OrderStatus status = OrderStatus.OPEN;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientEntity client;

  @OneToMany
  private List<OrderItemEntity> items;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;

  public void sell() {
    if (this.status != OrderStatus.OPEN) {
      throw new OrderIsNotOpenException();
    }

    this.status = OrderStatus.PAID;
  }

  public BigDecimal getPrice() {
    return items.stream()
        .map(OrderItemEntity::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal getTotalPrice() {
    return items.stream()
        .map(OrderItemEntity::getTotalPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal getDiscountPrice() {
    return items.stream()
        .map(OrderItemEntity::getDiscountPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

}
