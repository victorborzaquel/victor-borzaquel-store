package com.ada.victorborzaquelstore.modules.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductOrderDTO {
  @NotNull
  private UUID productId;

  @NotNull
  @Min(1)
  private Integer quantity;
}
