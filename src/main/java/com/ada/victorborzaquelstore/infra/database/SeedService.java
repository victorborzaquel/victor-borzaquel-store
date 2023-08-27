package com.ada.victorborzaquelstore.infra.database;

import com.ada.victorborzaquelstore.infra.integrations.dummyjson.services.DummyJsonService;
import com.ada.victorborzaquelstore.modules.product.ProductEntity;
import com.ada.victorborzaquelstore.repositories.ProductRepository;
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
