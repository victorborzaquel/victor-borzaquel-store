package com.ada.victorborzaquelstore.modules.address.entities;

import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
  @JoinColumn(name = "client_id")
  private ClientEntity client;

}
