package com.ada.victorborzaquelstore.modules.user;

import com.ada.victorborzaquelstore.modules.address.AddressEntity;
import com.ada.victorborzaquelstore.modules.order.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "cpf", unique = true)
  private String cpf;

  @OneToMany(mappedBy = "user")
  private List<AddressEntity> addresses;

  @OneToMany(mappedBy = "user")
  private List<OrderEntity> orders;

}
