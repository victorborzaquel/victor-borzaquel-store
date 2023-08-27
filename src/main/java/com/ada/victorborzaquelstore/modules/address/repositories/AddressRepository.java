package com.ada.victorborzaquelstore.modules.address.repositories;

import com.ada.victorborzaquelstore.modules.address.entities.AddressEntity;
import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
  Page<AddressEntity> findAllByClient(ClientEntity client, Pageable pageable);
}
