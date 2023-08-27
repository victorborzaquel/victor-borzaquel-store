package com.ada.victorborzaquelstore.modules.product.mappers;

import com.ada.victorborzaquelstore.integrations.dummyjson.dto.DummyJsonProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDTO;
import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  ResponseProductDTO toDto(ProductEntity entity);

  ProductEntity toEntity(CreateProductDTO dto);

  @Mapping(target = "id", ignore = true)
  ProductEntity toEntity(DummyJsonProductDTO dto);
}
