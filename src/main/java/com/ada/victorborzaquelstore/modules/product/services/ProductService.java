package com.ada.victorborzaquelstore.modules.product.services;

import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDTO;
import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import com.ada.victorborzaquelstore.modules.product.exceptions.ProductNotFoundException;
import com.ada.victorborzaquelstore.modules.product.mappers.ProductMapper;
import com.ada.victorborzaquelstore.modules.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository repository;

  public ResponseProductDTO create(CreateProductDTO dto) {
    ProductEntity entity = ProductMapper.INSTANCE.toEntity(dto);
    ProductEntity response = repository.save(entity);
    return ProductMapper.INSTANCE.toDto(response);
  }

  public Page<ResponseProductDTO> getAll(Pageable pageable) {
    Page<ProductEntity> response = repository.findAll(pageable);
    return response.map(ProductMapper.INSTANCE::toDto);
  }

  public boolean checkStock(UUID id, Integer quantity) {
    ProductEntity product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
    return product.getStock() >= quantity;
  }

  public void decreaseStock(UUID id, Integer quantity) {
    ProductEntity product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
    product.decreaseStock(quantity);
    repository.save(product);
  }

  public void increaseStock(UUID id, Integer quantity) {
    ProductEntity product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
    product.increaseStock(quantity);
    repository.save(product);
  }
}
