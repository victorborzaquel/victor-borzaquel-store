package com.ada.victorborzaquelstore.modules.product;

import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDto;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDto;
import com.ada.victorborzaquelstore.modules.product.dto.UpdateProductDto;
import com.ada.victorborzaquelstore.modules.product.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

  public ResponseProductDto create(CreateProductDto dto) {
    ProductEntity entity = this.productMapper.toEntity(dto);
    ProductEntity response = this.productRepository.save(entity);
    return this.productMapper.toDto(response);
  }

  public ResponseProductDto update(UUID id, UpdateProductDto dto) {
    ProductEntity entity = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    this.productMapper.updateFromDto(entity, dto);
    ProductEntity response = this.productRepository.save(entity);
    return this.productMapper.toDto(response);
  }
}
