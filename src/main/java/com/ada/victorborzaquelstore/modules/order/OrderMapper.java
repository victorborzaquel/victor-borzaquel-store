package com.ada.victorborzaquelstore.modules.order;

import com.ada.victorborzaquelstore.modules.order.dto.CreateOrderDTO;
import com.ada.victorborzaquelstore.modules.order.dto.ResponseOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderItemMapper.class})
public interface OrderMapper {

  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  @Mapping(target = "items", source = "items", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ResponseOrderDTO toResponse(OrderEntity entity);

  @Mapping(target = "client.id", source = "clientId")
  OrderEntity toEntity(CreateOrderDTO dto);
}
