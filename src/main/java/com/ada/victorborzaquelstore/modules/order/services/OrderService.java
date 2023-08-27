package com.ada.victorborzaquelstore.modules.order.services;

import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import com.ada.victorborzaquelstore.modules.employee.entities.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.employee.repositories.EmployeeRepository;
import com.ada.victorborzaquelstore.modules.mail.dto.CreateMailDto;
import com.ada.victorborzaquelstore.modules.mail.enums.MailStatus;
import com.ada.victorborzaquelstore.modules.mail.providers.MailProvider;
import com.ada.victorborzaquelstore.modules.mail.services.MailOrderService;
import com.ada.victorborzaquelstore.modules.mail.services.MailService;
import com.ada.victorborzaquelstore.modules.order.dto.ResponseOrderDTO;
import com.ada.victorborzaquelstore.modules.order.entities.OrderEntity;
import com.ada.victorborzaquelstore.modules.order.entities.OrderItemEntity;
import com.ada.victorborzaquelstore.modules.order.enums.OrderStatus;
import com.ada.victorborzaquelstore.modules.order.exceptions.OrderIsNotOpenException;
import com.ada.victorborzaquelstore.modules.order.exceptions.OrderNotFoundException;
import com.ada.victorborzaquelstore.modules.order.repositories.OrderRepository;
import com.ada.victorborzaquelstore.modules.product.exceptions.ProductNotHaveInStockException;
import com.ada.victorborzaquelstore.modules.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

  private final OrderRepository orderRepository;

  private final ProductService productService;

  private final MailOrderService mailOrderService;

  private final EmployeeRepository employeeRepository;

  public ResponseOrderDTO buy(UUID id, UUID clientId) {
    OrderEntity order = this.orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);

    if (order.getClient().getId() != clientId) {
      throw new OrderNotFoundException();
    }

    if (order.getItems().isEmpty()) {
      throw new OrderNotFoundException();
    }

    if (order.getStatus() != OrderStatus.OPEN) {
      throw new OrderIsNotOpenException();
    }

    for (OrderItemEntity item : order.getItems()) {
      if (!this.productService.checkStock(item.getProduct().getId(), item.getQuantity())) {
        throw new ProductNotHaveInStockException();
      }
    }

    for (OrderItemEntity item : order.getItems()) {
      this.productService.decreaseStock(item.getProduct().getId(), item.getQuantity());
    }

    order.sell();

    this.mailOrderService.clientBuyOrderEmailToClient(order.getClient().getUser().getEmail());

    this.employeeRepository.findBy

    this.mailOrderService.clientBuyOrderEmailToSalesManager(order.getClient().getUser().getEmail());
  }

  public ResponseOrderDTO removeProduct(UUID id, UUID clientId, UUID productId) {
    return null;
  }

  public ResponseOrderDTO addProduct(UUID id, UUID clientId, UUID productId) {
    return null;

  }

  public ResponseOrderDTO increaseProductQuantity(UUID id, UUID clientId, UUID productId, Integer quantity) {
    return null;
  }

  public ResponseOrderDTO decreaseProductQuantity(UUID id, UUID clientId, UUID productId, Integer quantity) {
    return null;
  }
}
