package com.ada.victorborzaquelstore.modules.order;

import com.ada.victorborzaquelstore.modules.user.UserEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;


}
