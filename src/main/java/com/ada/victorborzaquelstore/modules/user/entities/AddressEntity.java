package com.ada.victorborzaquelstore.modules.user.entities;

import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "addresses")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "street")
  private String street;

  @Column(name = "number")
  private String number;

  @Column(name = "complement")
  private String complement;

  @Column(name = "zipcode")
  private String zipcode;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

}
