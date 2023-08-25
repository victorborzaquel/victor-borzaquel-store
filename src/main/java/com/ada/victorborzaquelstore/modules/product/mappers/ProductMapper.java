package com.ada.victorborzaquelstore.modules.product.mappers;

import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.UpdateProductDTO;
import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper
public interface ProductMapper {
  ProductEntity toEntity(CreateProductDTO dto);

  ProductEntity toEntity(UUID id, UpdateProductDTO dto);

  ResponseProductDTO toDto(ProductEntity entity);

  @Mapping(target = "id", ignore = true)
  void updateFromDto(@MappingTarget ProductEntity target, UpdateProductDTO dto);
}
