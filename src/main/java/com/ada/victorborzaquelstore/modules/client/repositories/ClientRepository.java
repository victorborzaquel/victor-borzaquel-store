package com.ada.victorborzaquelstore.modules.client.repositories;

import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
}
