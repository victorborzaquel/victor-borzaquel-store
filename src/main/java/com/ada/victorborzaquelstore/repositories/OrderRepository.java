package com.ada.victorborzaquelstore.repositories;

import com.ada.victorborzaquelstore.modules.order.OrderEntity;
import com.ada.victorborzaquelstore.modules.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
  Optional<OrderEntity> findByClientIdAndStatus(UUID clientId, OrderStatus status);
}
