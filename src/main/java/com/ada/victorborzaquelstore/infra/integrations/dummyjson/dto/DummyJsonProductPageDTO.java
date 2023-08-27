package com.ada.victorborzaquelstore.infra.integrations.dummyjson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DummyJsonProductPageDTO {
  private List<DummyJsonProductDTO> products;
  private Integer total;
  private Integer skip;
  private Integer limit;
}
