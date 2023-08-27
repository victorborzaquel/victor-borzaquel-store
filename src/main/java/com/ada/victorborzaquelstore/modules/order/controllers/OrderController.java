package com.ada.victorborzaquelstore.modules.order.controllers;

import com.ada.victorborzaquelstore.modules.order.dto.ResponseOrderDTO;
import com.ada.victorborzaquelstore.modules.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

  private final OrderService orderService;

  @PostMapping("{id}/buy")
  public ResponseOrderDTO buy(@PathVariable UUID id) {
    return orderService.buy(id, null);
  }

  @DeleteMapping("{id}/remove-product/{productId}")
  public ResponseOrderDTO removeProduct(@PathVariable UUID id, @PathVariable UUID productId) {
    return orderService.removeProduct(id, null, productId);
  }

  @PostMapping("{id}/add-product/{productId}")
  public ResponseOrderDTO addProduct(@PathVariable UUID id, @PathVariable UUID productId) {
    return orderService.addProduct(id, null, productId);
  }

  @PatchMapping("{id}/increase-product-quantity}/{productId}")
  public ResponseOrderDTO increaseProductQuantity(
      @PathVariable UUID id,
      @PathVariable UUID productId,
      @RequestParam(defaultValue = "1") Integer quantity
  ) {
    return orderService.increaseProductQuantity(id, null, productId, quantity);
  }

  @PatchMapping("{id}/decrease-product-quantity/{productId}")
  public ResponseOrderDTO decreaseProductQuantity(
      @PathVariable UUID id,
      @PathVariable UUID productId,
      @RequestParam(defaultValue = "1") Integer quantity
  ) {
    return orderService.decreaseProductQuantity(id, null, productId, quantity);
  }
}
