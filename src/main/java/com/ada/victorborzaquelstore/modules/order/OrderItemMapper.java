package com.ada.victorborzaquelstore.modules.order;

import com.ada.victorborzaquelstore.modules.order.dto.ResponseOrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderItemMapper {

  OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

  ResponseOrderItemDTO toResponse(OrderItemEntity entity);

  List<ResponseOrderItemDTO> toResponse(List<ResponseOrderItemDTO> entities);
}
