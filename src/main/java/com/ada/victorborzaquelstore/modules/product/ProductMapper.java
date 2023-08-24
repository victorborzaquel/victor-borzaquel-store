package com.ada.victorborzaquelstore.modules.product;

import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDto;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDto;
import com.ada.victorborzaquelstore.modules.product.dto.UpdateProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper
public interface ProductMapper {
  ProductEntity toEntity(CreateProductDto dto);

  ProductEntity toEntity(UUID id, UpdateProductDto dto);

  ResponseProductDto toDto(ProductEntity entity);

  @Mapping(target = "id", ignore = true)
  void updateFromDto(@MappingTarget ProductEntity target, UpdateProductDto dto);
}
