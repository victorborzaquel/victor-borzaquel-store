package com.ada.victorborzaquelstore.api.v1;

import com.ada.victorborzaquelstore.modules.product.ProductService;
import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDto;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDto;
import com.ada.victorborzaquelstore.modules.product.dto.UpdateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseProductDto create(@RequestBody CreateProductDto dto) {
    return this.productService.create(dto);
  }

  @PatchMapping("{id}")
  public ResponseProductDto update(@PathVariable UUID id, @RequestBody UpdateProductDto dto) {
    return this.productService.update(id, dto);
  }
}
