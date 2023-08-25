package com.ada.victorborzaquelstore.modules.product.services;

import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.UpdateProductDTO;
import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import com.ada.victorborzaquelstore.modules.product.exceptions.ProductNotFoundException;
import com.ada.victorborzaquelstore.modules.product.mappers.ProductMapper;
import com.ada.victorborzaquelstore.modules.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

  public ResponseProductDTO create(CreateProductDTO dto) {
    ProductEntity entity = this.productMapper.toEntity(dto);
    ProductEntity response = this.productRepository.save(entity);
    return this.productMapper.toDto(response);
  }

  public ResponseProductDTO update(UUID id, UpdateProductDTO dto) {
    ProductEntity entity = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    this.productMapper.updateFromDto(entity, dto);
    ProductEntity response = this.productRepository.save(entity);
    return this.productMapper.toDto(response);
  }
}
