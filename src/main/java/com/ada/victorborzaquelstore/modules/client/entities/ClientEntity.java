package com.ada.victorborzaquelstore.modules.client.entities;

import com.ada.victorborzaquelstore.modules.address.entities.AddressEntity;
import com.ada.victorborzaquelstore.modules.order.entities.OrderEntity;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id", unique = true, nullable = false)
  private UserEntity user;

  @OneToMany(mappedBy = "client")
  private List<AddressEntity> addresses;

  @OneToMany(mappedBy = "client")
  private List<OrderEntity> orders;

  public ClientEntity(UUID id) {
    this.id = id;
  }
}
