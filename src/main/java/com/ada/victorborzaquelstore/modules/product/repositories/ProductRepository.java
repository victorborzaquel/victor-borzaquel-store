package com.ada.victorborzaquelstore.modules.product.repositories;

import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
