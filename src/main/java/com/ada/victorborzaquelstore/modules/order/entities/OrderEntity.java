package com.ada.victorborzaquelstore.modules.order.entities;

import com.ada.victorborzaquelstore.modules.user.entities.AddressEntity;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "total")
  private Double total;

  @Column(name = "status")
  private String status;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @OneToMany
  private List<OrderItemEntity> orderItems;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;
}
