package com.ada.victorborzaquelstore.controllers;

import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDTO;
import com.ada.victorborzaquelstore.services.ProductService;
import com.ada.victorborzaquelstore.shared.utils.PageableUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public Page<ResponseProductDTO> getAll(@PathVariable(required = false) Pageable pageable) {
    return productService.getAll(PageableUtil.pageable(pageable));
  }
}
