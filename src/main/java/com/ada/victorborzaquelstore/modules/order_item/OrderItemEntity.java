package com.ada.victorborzaquelstore.modules.order_item;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


}
