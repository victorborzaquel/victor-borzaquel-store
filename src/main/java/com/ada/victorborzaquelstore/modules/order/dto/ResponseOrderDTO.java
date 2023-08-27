package com.ada.victorborzaquelstore.modules.order.dto;

import com.ada.victorborzaquelstore.modules.address.dto.ResponseAddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrderDTO {
  private UUID id;
  private UUID clientId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime closedAt;
  private BigDecimal price;
  private BigDecimal discountPrice;
  private BigDecimal totalPrice;
  private ResponseAddressDTO address;
  private List<ResponseOrderItemDTO> items;
}
