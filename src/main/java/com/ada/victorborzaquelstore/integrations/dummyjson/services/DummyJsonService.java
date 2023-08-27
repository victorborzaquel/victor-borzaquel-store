package com.ada.victorborzaquelstore.integrations.dummyjson.services;

import com.ada.victorborzaquelstore.integrations.dummyjson.dto.DummyJsonProductPageDTO;
import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import com.ada.victorborzaquelstore.modules.product.mappers.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DummyJsonService {
  private final RestTemplate restTemplate = new RestTemplate();

  public DummyJsonProductPageDTO getProducts() {
    String url = "https://dummyjson.com/products";
    return restTemplate.getForObject(url, DummyJsonProductPageDTO.class);
  }

  public List<ProductEntity> getProductsAsEntities() {
    return this.getProducts().getProducts().stream().map(ProductMapper.INSTANCE::toEntity).toList();
  }
}
