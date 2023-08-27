package com.ada.victorborzaquelstore.shared.seed.services;

import com.ada.victorborzaquelstore.integrations.dummyjson.services.DummyJsonService;
import com.ada.victorborzaquelstore.modules.product.entities.ProductEntity;
import com.ada.victorborzaquelstore.modules.product.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SeedService {

  private final DummyJsonService dummyJsonService;
  private final ProductRepository productRepository;

  @PostConstruct
  public void init() {
    if (this.productRepository.count() == 0) {
      List<ProductEntity> products = this.dummyJsonService.getProductsAsEntities();

      productRepository.saveAll(products);

      System.out.println("Products seeded.");
    }
  }

}
