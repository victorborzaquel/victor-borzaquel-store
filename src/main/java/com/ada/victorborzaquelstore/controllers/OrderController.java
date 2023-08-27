package com.ada.victorborzaquelstore.controllers;

import com.ada.victorborzaquelstore.modules.order.dto.ResponseOrderDTO;
import com.ada.victorborzaquelstore.services.OrderService;
import com.ada.victorborzaquelstore.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

  private final OrderService orderService;
  private final RequestService requestService;

  @PostMapping("{id}/buy")
  public ResponseOrderDTO buy(@PathVariable UUID id) {
    return orderService.buy(id, null);
  }

  @DeleteMapping("{id}/remove-product/{productId}")
  public ResponseOrderDTO removeProduct(@PathVariable UUID id, @PathVariable UUID productId) {
    String sub = this.requestService.currentSub();

    return orderService.removeProduct(id, sub, productId);
  }

  @PostMapping("{id}/add-product/{productId}")
  public ResponseOrderDTO addProduct(
      @PathVariable UUID id,
      @PathVariable UUID productId,
      @RequestParam(defaultValue = "1") Integer quantity
  ) {
    String sub = this.requestService.currentSub();

    return orderService.addProduct(id, sub, productId, quantity);
  }

  @PatchMapping("{id}/increase-product-quantity/{productId}")
  public ResponseOrderDTO increaseProductQuantity(
      @PathVariable UUID id,
      @PathVariable UUID productId,
      @RequestParam(defaultValue = "1") Integer quantity
  ) {
    String sub = this.requestService.currentSub();

    return orderService.increaseProductQuantity(id, sub, productId, quantity);
  }

  @PatchMapping("{id}/decrease-product-quantity/{productId}")
  public ResponseOrderDTO decreaseProductQuantity(
      @PathVariable UUID id,
      @PathVariable UUID productId,
      @RequestParam(defaultValue = "1") Integer quantity
  ) {
    String sub = this.requestService.currentSub();

    return orderService.decreaseProductQuantity(id, sub, productId, quantity);
  }
}
