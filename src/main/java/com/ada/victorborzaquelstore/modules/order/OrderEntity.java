package com.ada.victorborzaquelstore.modules.order;

import com.ada.victorborzaquelstore.modules.address.AddressEntity;
import com.ada.victorborzaquelstore.modules.client.ClientEntity;
import com.ada.victorborzaquelstore.shared.exceptions.OrderIsNotOpenException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    if (items == null || items.isEmpty()) {
      return BigDecimal.ZERO;
    }

    return items.stream()
        .map(OrderItemEntity::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal getTotalPrice() {
    if (items == null || items.isEmpty()) {
      return BigDecimal.ZERO;
    }

    return items.stream()
        .map(OrderItemEntity::getTotalPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal getDiscountPrice() {
    if (items == null || items.isEmpty()) {
      return BigDecimal.ZERO;
    }

    return items.stream()
        .map(OrderItemEntity::getDiscountPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public void addItem(OrderItemEntity item) {
    items.add(item);
  }
}
