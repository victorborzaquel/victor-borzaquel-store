package com.ada.victorborzaquelstore.repositories;

import com.ada.victorborzaquelstore.modules.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
  Optional<ClientEntity> findByUserUsername(String username);
}
